package com.yeah.zhongchou.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeah.zhongchou.dao.jdbc.ProjectDaoImpl;
import com.yeah.zhongchou.entity.Project;
import net.sf.json.JSONArray;

/** * @author https://www.yeee.vip  作者 E-mail: * @date 创建时间：2016年12月14日 上午11:33:12 * @version 1.0 * @parameter  * @since  * @return  */
public class adminProjectAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		req.setCharacterEncoding("utf-8");
//		resp.setCharacterEncoding("utf-8");
		String reqPath = req.getRequestURI();
		String action = reqPath.substring(reqPath.lastIndexOf("/"));
		
	if(action.equals("/adminProject.jhtml")){
		String adminPageStr = req.getParameter("adminPage");
		Integer adminPage;
		try{
			adminPage= Integer.parseInt(adminPageStr);
		}catch(NumberFormatException e){
			adminPage = 1;
		}
		List<Project> projects = null;
		try {
			projects = projectDaoImpl.getProjectByCondition(new Project(),adminPage,1000);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("projects", projects);
		
		
		/**
		 * 吧所有 的项目放在json数组
		 */
		JSONArray pJson = JSONArray.fromObject(projects);
		PrintWriter out = resp.getWriter();
		out.print(pJson);
		out.flush();
		out.close();
	}	
	
	if(action.equals("/auditsProject.jhtml")){
		String adminPageStr = req.getParameter("adminPage");
		Integer adminPage;
		try{
			adminPage= Integer.parseInt(adminPageStr);
		}catch(NumberFormatException e){
			adminPage = 1;
		}
		
		List<Project> projects = null;
        Project query = new Project();
        query.setIs_audits(0);
		try {
			projects = projectDaoImpl.getProjectByCondition(query,adminPage,10000);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONArray pJson = JSONArray.fromObject(projects);
		PrintWriter out = resp.getWriter();
		out.print(pJson);
		out.flush();
		out.close();
	
	}
	
	if(action.equals("/shenhe.jhtml")){
		int id = Integer.parseInt(req.getParameter("id"));
		Project project = new Project();
		try {
			project = projectDaoImpl.getProjectById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("project", project);
		String pageJsp = "/shenhe.jsp";
		req.getRequestDispatcher(pageJsp).forward(req, resp);

	}
	if(action.equals("/passAudits.jhtml")){
		int project_id = Integer.parseInt(req.getParameter("project_id"));

		int is_audits = Integer.parseInt(req.getParameter("is_audits"));

		String res = "操作成功！";
		
		try {
			projectDaoImpl.passAudits(project_id, is_audits);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = "操作失败---->"+e.getMessage();
		}

		resp.getWriter().print(res);
		
	}
	

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	
}
