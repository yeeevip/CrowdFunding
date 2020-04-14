package com.yeah.zhongchou.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yeah.zhongchou.constant.Constants;

public class CodeAction extends HttpServlet {
	private static final long serialVersionUID = 1736370958785036518L;

	// 验证码字体
	private Font[] codeFont = { new Font("Times New Roman", Font.PLAIN, 30),
			new Font("Times New Roman", Font.PLAIN, 30), new Font("Times New Roman", Font.PLAIN, 30),
			new Font("Times New Roman", Font.PLAIN, 30) };

	// 验证码数字颜色
	private Color[] color = { Color.BLACK, Color.RED, Color.DARK_GRAY, Color.BLUE };

	private String codeNumbers = "";

	private final String IMAGE_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	private final Integer IMAGE_WIDTH = 120;
	private final Integer IMAGE_HEIGHT = 40;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 设置请求头为gif的图片类型
		response.setContentType("image/gif");

		/* 不设置缓存，页面不使用缓存 */
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// 创建一个图像,验证码显示的图片大小
		BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);

		// 获取图形绘制对象
		Graphics g = image.getGraphics();

		// 绘制图片背景颜色
		g.setColor(createRandomColor(200, 250));

		// 绘制背景图片
		g.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

		// 循环产生4位随机数
		for (int i = 0; i < 4; i++)
			drawString(g, i);

		// 添加干扰线
		drawNoise(g, 12);

		// 将生成的验证码字符串保存起来
		saveCodeInSession(request);

		// 重设字符串
		codeNumbers = "";
		// 利用ImageIO类的write方法对图像进行编码
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(image, "GIF", sos);
		sos.close();
	}

	/**
	 * 产生随即号
	 * 
	 * @param graphics
	 *            绘图对象
	 * @param i
	 *            随机数序号
	 */
	private void drawString(Graphics graphics, int i) {
		Random random = new Random();
		// 产生随即切割序号
		/* 0-61.9999 */
		Integer j = random.nextInt((IMAGE_CHAR.length()));
		// 切割随机数
		String number = IMAGE_CHAR.substring(j, j + 1);
		graphics.setFont(codeFont[i]);
		graphics.setColor(color[i]);
		// 绘制验证码到图片X、Y（每个字体x每次步进13的倍数，y不变，大小6*6）
		graphics.drawString(number, 20 + i * 20, 30);

		codeNumbers += number;
	}


	/**
	 * 产生随即背景色
	 * 
	 * @param fc
	 *            背景色色调边界
	 * @param bc
	 *            背景色色调边界
	 * @return 背景色
	 */
	private Color createRandomColor(int fc, int bc) {// 给定范围获得随机颜色
		// 随机对象
		Random random = new Random();
		// 随机初始数值不得大于255
		if (fc > 255)
			fc = 255;
		// 随机初始数值不得大于255
		if (bc > 255)
			bc = 255;
		// 产生随机红蓝绿色调
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}


	/**
	 * 绘制干扰线
	 * 
	 * @param graphics
	 *            绘图对象
	 * @param lineNumber
	 *            绘制数量
	 */
	private void drawNoise(Graphics graphics, int lineNumber) {
		// 干扰线颜色
		graphics.setColor(createRandomColor(160, 200));
		for (int i = 0; i < lineNumber; i++) {
			// 线的启示X轴(只在80,20的范围内随机，由于从零开始，所以要加一)
			int pointX1 = 1 + (int) (Math.random() * 120);
			// 线的启示Y轴(只在80,20的范围内随机，由于从零开始，所以要加一)
			int pointY1 = 1 + (int) (Math.random() * 40);
			// 线的终止X轴(只在80,20的范围内随机，由于从零开始，所以要加一)
			int pointX2 = 1 + (int) (Math.random() * 120);
			// 线的终止Y轴(只在80,20的范围内随机，由于从零开始，所以要加一)
			int pointY2 = 1 + (int) (Math.random() * 40);
			graphics.drawLine(pointX1, pointY1, pointX2, pointY2);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void saveCodeInSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		// 将之前的验证码移除，把新的验证码内容保存进session中
		session.setAttribute(Constants.CHECK_NUMBER_NAME, codeNumbers);
	}
}
