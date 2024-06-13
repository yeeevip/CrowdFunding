package vip.yeee.zhongchou.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.yeee.zhongchou.dao.ProjectDao;
import vip.yeee.zhongchou.entity.Project;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class IndexAction extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	//private ProjectDaoImpl proj;
	private final ProjectDao projectDao = new ProjectDao();
	
	
	Integer is=1;//在首页显示
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//公益项目
		List<Project> gy = null;
		try {
			gy = projectDao.getProjectByIs_index(is,1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("gy",gy);
		
		//农业
		List<Project> ny = null;
		try {
			ny = projectDao.getProjectByIs_index(is, 2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("ny", ny);
		
		//出版
		List<Project> cb = null;
		try {
			cb = projectDao.getProjectByIs_index(is, 3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("cb",cb);
		
		//艺术
		List<Project> ys = null;
		try {
			ys = projectDao.getProjectByIs_index(is, 4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("ys", ys);
		
		//娱乐
		List<Project> yl = null;
		try {
			yl = projectDao.getProjectByIs_index(is, 5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("yl", yl);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
