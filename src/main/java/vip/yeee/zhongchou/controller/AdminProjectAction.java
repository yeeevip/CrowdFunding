package vip.yeee.zhongchou.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.yeee.zhongchou.dao.ProjectDao;
import vip.yeee.zhongchou.entity.Project;
import net.sf.json.JSONArray;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class AdminProjectAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProjectDao projectDao = new ProjectDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setCharacterEncoding("utf-8");
		String reqPath = req.getRequestURI();
		String action = reqPath.substring(reqPath.lastIndexOf("/"));
		
	if(action.equals("/adminProject.jhtml")){
		String adminPageStr = req.getParameter("adminPage");
		int adminPage;
		try{
			adminPage= Integer.parseInt(adminPageStr);
		}catch(NumberFormatException e){
			adminPage = 1;
		}
		List<Project> projects = null;
		try {
			projects = projectDao.getProjectByCondition(new Project(),adminPage,1000);
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
		int adminPage;
		try{
			adminPage= Integer.parseInt(adminPageStr);
		}catch(NumberFormatException e){
			adminPage = 1;
		}
		
		List<Project> projects = null;
        Project query = new Project();
        query.setIs_audits(0);
		try {
			projects = projectDao.getProjectByCondition(query,adminPage,10000);
		} catch (SQLException e) {
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
			project = projectDao.getProjectById(id);
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
			projectDao.passAudits(project_id, is_audits);
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
