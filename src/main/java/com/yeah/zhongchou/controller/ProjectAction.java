package com.yeah.zhongchou.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yeah.zhongchou.constant.Constants;
import com.yeah.zhongchou.dao.ProjectDao;
import com.yeah.zhongchou.dao.jdbc.CommentDaoImpl;
import com.yeah.zhongchou.dao.jdbc.ProjectDaoImpl;
import com.yeah.zhongchou.dao.jdbc.ProjectProgressDaoImpl;
import com.yeah.zhongchou.entity.Comment;
import com.yeah.zhongchou.entity.Project;
import com.yeah.zhongchou.entity.ProjectProgress;
import com.yeah.zhongchou.entity.ProjectRepay;
import com.yeah.zhongchou.entity.Projectdetail;


public class ProjectAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		//项目id
		String project_id = request.getParameter("id");
		Integer id =-1;
		try{
			id = Integer.parseInt(project_id);
		}catch(NumberFormatException e){
			//如果参数不合法，则跳转到首页
			response.sendRedirect("index.jhtml");
			return;
		};
		ProjectDao proj = new ProjectDaoImpl();
		Project p = null;
		List<ProjectProgress> pp = null;
		try {
			ProjectProgressDaoImpl projectProgressDaoImpl = new ProjectProgressDaoImpl();
			
			pp = projectProgressDaoImpl.queryProjectProgress(id);
			
			p = proj.getProjectById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("p", p);
		List<Projectdetail> pd = p.getProjectdetail();
		request.setAttribute("pd", pd);
		List<ProjectRepay> pr = p.getProjectRepay();
		request.setAttribute("pr", pr);
		
		
		request.setAttribute("pp", pp);
		
/*		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User lunchUser = null;
		try {
			lunchUser = userDaoImpl.getUserById(p.getUser_id());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.setAttribute("lunchUser", lunchUser.getId());*/
		
		
		//评论数据
		
		int page = 1;
		CommentDaoImpl commentDaoImpl = new CommentDaoImpl();
		List<Comment> comments = null;
		try {
			comments = commentDaoImpl.getCommentByProject(id, page);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("comments", comments);
		//System.out.println("-----"+comments.toString());
		//System.out.println(comments.get(0).getUser());
//		JSONObject json = new JSONObject().fromObject(comments);

		
		
		
		HttpSession session = request.getSession();
		session.setAttribute(Constants.PROJECT_KEY, p);
		
		request.getRequestDispatcher("/project.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		doGet(request, response);
}
	
}
