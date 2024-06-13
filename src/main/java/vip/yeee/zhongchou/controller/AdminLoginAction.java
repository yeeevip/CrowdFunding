package vip.yeee.zhongchou.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class AdminLoginAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		doGet(request, response);
}

}
