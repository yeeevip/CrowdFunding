package com.yeah.zhongchou.constant;/** * @author  作者 E-mail: * @date 创建时间：2016年12月13日 下午4:46:29 * @version 1.0 * @parameter  * @since  * @return  */
public class Globle {
	//存放验证码字符
	private static String code;
	public static String getCode(){
		return code;
	}
	public static void setCode(String code){
		Globle.code= code;
	}

}
