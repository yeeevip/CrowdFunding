package com.yeah.zhongchou.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeah.zhongchou.constant.Constants;
import com.yeah.zhongchou.dao.jdbc.UserDaoImpl;
import com.yeah.zhongchou.entity.User;

/** * @author  作者 E-mail: * @date 创建时间：2016年12月15日 下午10:17:50 * @version 1.0 * @parameter  * @since  * @return  */
public class ReviseUserAction extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDaoImpl = new UserDaoImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//修改个人基本资料
		User user = (User) req.getSession().getAttribute(Constants.USER_KEY);
		try {
			updateUser(req, resp, user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		PrintWriter out = resp.getWriter();
		out.print(true);
		out.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	private void updateUser(HttpServletRequest request,HttpServletResponse response,User user) throws ServletException,IOException, SQLException{
		/**
		 * 获取用户提交的信息
		 */
		String sex = request.getParameter("sex");
		String user_name = request.getParameter("user_name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String real_name = request.getParameter("real_name");
		String id_number = request.getParameter("id_number");
		
		// 将数据封装到user对象
		user.setId_number(id_number);
		user.setUser_name(user_name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setReal_name(real_name);
		user.setSex(sex);
		

		userDaoImpl.update(user);

		// 更新后的数据保存进session
		request.getSession().setAttribute(Constants.USER_KEY, user);
	}
	

}
