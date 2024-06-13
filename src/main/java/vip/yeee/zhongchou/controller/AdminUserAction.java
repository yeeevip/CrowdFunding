package vip.yeee.zhongchou.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.yeee.zhongchou.dao.UserDao;
import vip.yeee.zhongchou.entity.User;
import net.sf.json.JSONArray;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class AdminUserAction extends HttpServlet {

	private static final long  serialVersionUID = 1L;
	private final UserDao userDao = new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			users = userDao.getUsersByCondition("", page);
		} catch (SQLException e) {
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
		doGet(req,resp);
	}
	
	
}
