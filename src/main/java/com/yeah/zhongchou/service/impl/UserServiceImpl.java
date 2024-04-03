package com.yeah.zhongchou.service.impl;



import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.yeah.zhongchou.service.UserService;

import com.yeah.zhongchou.dao.jdbc.UserDaoImpl;
import com.yeah.zhongchou.entity.User;
import com.yeah.zhongchou.utils.Untils;
/**
 * 用户表的Service类
 */
/** * @author https://www.yeee.vip  作者 E-mail: * @date 创建时间：2016年12月12日 下午4:10:20 * @version 1.0 * @parameter  * @since  * @return  */
public class UserServiceImpl implements UserService {

	private UserDaoImpl userDaoImpl=new UserDaoImpl();
	
	@Override
	public void registUser(String condition,String password) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		//如果用户输入的是邮箱号码
		if (Untils.isEmail(condition))
			user.setEmail(condition);
		//否则用户输入的就是手机号码
		else
			user.setPhone(condition);
		//设置用户密码
		user.setPassword(Untils.toMD5(password));
		
		Date current_date = new Date();//生成日期对象
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式样式为yyyy-MM-dd
		
		user.setDate_of_registration(simpleDateFormat.format(current_date.getTime()));
		userDaoImpl.save(user);
		
		
	}
	
	/**
	 * 检查验证码信息
	 */
	@Override
	public boolean checkCode(String right_code, String code) {
		// TODO Auto-generated method stub
		if(right_code == null || "".equals(right_code))
			return false;
		right_code = right_code.toUpperCase();
		code = code.toUpperCase();
		
		if(right_code.equals(code))
			return true;
		return false;
		
	}
	
	/**
	 * 验证手机和邮箱的唯一性
	 * @throws SQLException 
	 * 
	 */
	@Override
	public boolean checkPhoneAndEmail(String phone, String email, User user) throws SQLException {
		// TODO Auto-generated method stub
		if (!phone.equals(user.getPhone()))
			if (userDaoImpl.getUserByCondition(phone)!=null)
				return false;

		if (!email.equals(user.getEmail()))
			if (userDaoImpl.getUserByCondition(email)!=null)
				return false;

		return true;
	}



}
