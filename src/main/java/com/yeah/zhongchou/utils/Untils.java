package com.yeah.zhongchou.utils;/** * @author https://www.yeee.vip  作者 E-mail: * @date 创建时间：2016年12月12日 下午4:19:57 * @version 1.0 * @parameter  * @since  * @return  */

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * 
 * 工具类，提供一些静态的功能函数
 *
 */
public class Untils {
	/**
	 * 判断入参是否满足邮箱格式xxx@xxx.xxx
	 * @param temp
	 * 
	 */
	public static boolean isEmail(String temp){
		String rule = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(rule);
		Matcher matcher = regex.matcher(temp);
		return matcher.matches();
	}
	
	/**
	 * 将字段进行MD5加密，主要用于密码部分
	 */
	public static String toMD5(String data){
		if(data == null)
			return null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			//加密转换
			md.update(data.getBytes());
			String result = new BigInteger(1,md.digest()).toString(16);
			return result;
		}catch(NoSuchAlgorithmException e){
			return null;
		}
	}
	
	/**
	 * 利用插件uploadify上传文件
	 * savePath 文件保存路径
	 * return文件保存路径
	 */
	public static String uploadify(HttpServletRequest request ,String savePath) throws IOException,ServletException{
		
		File f1 = new File(savePath);
		//如果文件夹不存在就新建一个
		if(!f1.exists()){
			f1.mkdirs();
		}
		
		//这个是文件上传所需要的类
		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload();
		List fileList = null;
		try{
			fileList = upload.parseRequest(request);
		}catch(FileUploadException e){
			e.printStackTrace();
			return null;
		}
		//迭代器，搜索前端发送过来的文件
		Iterator<FileItem> it = fileList.iterator();
		String name = "";//文件名
		String extName = "";//后缀
		while(it.hasNext()){
			FileItem item = it.next();
			//判断该表单项是否普通类型
			if(!item.isFormField()){
				name = item.getName();
//				long size = item.getSize();//文件大小
//				String type = item.getContentType();//文件类型
				//System.out.println(size +"   " +type);
				if(name == null || name.trim().equals("")){
					continue;
				}
				//扩展名格式，extName也就是文件的后缀,例如.txt
				if(name.lastIndexOf(".")>=0){
					extName = name.substring(name.lastIndexOf("."));
				}
				File file = null;
				do {
					//生成新的文件名
					name = UUID.randomUUID().toString();
					file = new File(savePath + name + extName);
				}while(file.exists());
				
				File saveFile = new File(savePath + name + extName);
				try {
					item.write(saveFile);//保存
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
		
		return (savePath + name + extName);
	}
	


}
