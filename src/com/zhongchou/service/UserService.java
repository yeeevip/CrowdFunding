package com.zhongchou.service;

import java.sql.SQLException;

import campsg.zhongchou.entity.User;

public interface UserService {
	
	/**
	 * 检查验证码是否一直
	 * @param right_code 正确的验证码
	 * @param code 输入的验证码
	 * @return 
	 */
	boolean checkCode(String right_code,String code);
	/**
	 * 需要保存的用户的邮箱或者手机
	 * @param condition
	 */
	void registUser(String condition,String password) throws SQLException ;
	/**
	 * 检查用户资料修改时，手机，邮箱是否重复
	 * @param phone 用户的手机号
	 * @param email 用户的邮箱
	 * @param user 当前检测的用户
	 * @return 
	 */
	boolean checkPhoneAndEmail(String phone,String email,User user) throws SQLException ;
	
}
