package com.yeah.zhongchou.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeah.zhongchou.dao.jdbc.UserDaoImpl;
import com.yeah.zhongchou.entity.User;
import net.sf.json.JSONArray;

/** * @author https://www.yeee.vip  作者 E-mail: * @date 创建时间：2016年12月14日 下午12:26:29 * @version 1.0 * @parameter  * @since  * @return  */
public class adminUserAction extends HttpServlet {

	private static final long  serialVersionUID = 1L;
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * //获取用户列表  分页显示
		 */
		String adminPage = req.getParameter("adminPage");
		String pageStr = req.getParameter("page");
		Integer page;
		try{
			page = Integer.parseInt(pageStr);
		}catch(NumberFormatException e){
			page = 1;
		}
		List<User> users = null;
		try {
			users = userDaoImpl.getUsersByCondition("", page);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 把用户放在json属猪
		 */
		JSONArray jUser = JSONArray.fromObject(users);
		PrintWriter out = resp.getWriter();
		out.print(jUser);
		out.flush();
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);	
		}
	
	
}
