package com.yeah.zhongchou.constant;

import java.awt.Color;
import java.awt.Font;

public class Constants {

	// 验证码的字体库
	protected static Font[] codeFont = { new Font("Times New Roman", Font.PLAIN, 30),
			new Font("Times New Roman", Font.PLAIN, 30), new Font("Times New Roman", Font.PLAIN, 30),
			new Font("Times New Roman", Font.PLAIN, 30) };

	// 验证码数字颜色库
	protected static Color[] color = { Color.BLACK, Color.RED, Color.DARK_GRAY, Color.BLUE };

	// 验证码的字符库
	protected static final String IMAGE_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	// 验证码的宽度
	protected static final Integer IMAGE_WIDTH = 120;

	// 验证码的高度
	protected static final Integer IMAGE_HEIGHT = 40;
	
	/**
	 * 验证码
	 */
	public static String CHECK_NUMBER_NAME = "identify_code";
	
	/**
	 * session中的用户id
	 */
	public static String USER_KEY = "user";
	/**
	 * session中的项目id
	 */
	public static String PROJECT_KEY = "project";
	/**
	 * session 文件名
	 */
	public static String FILE_NAME = "file";
}
