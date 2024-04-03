package com.yeah.zhongchou.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeah.zhongchou.constant.Constants;
import com.yeah.zhongchou.entity.Comment;
import com.yeah.zhongchou.entity.Project;
import com.yeah.zhongchou.entity.User;
import com.yeah.zhongchou.service.impl.CommentServiceImpl;
import com.yeah.zhongchou.dao.jdbc.CommentDaoImpl;
import net.sf.json.JSONObject;

/** * @author https://www.yeee.vip https://www.yeee.vip  作者 E-mail: * @date 创建时间：2016年12月14日 下午1:10:33 * @version 1.0 * @parameter  * @since  * @return  */
public class NewCommentAction extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CommentServiceImpl commentServiceImpl = new CommentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String content = req.getParameter("content");//评论信息
//		String p_idStr = req.getParameter("id");//当前项目id
//		
//		Integer p_id = Integer.parseInt(p_idStr);
		

		
		User user = (User) req.getSession().getAttribute(Constants.USER_KEY);//判断用户登陆状态
		int user_id = user.getId();//获取用户id
		//从session中获取当前项目id
		Project project = (Project) req.getSession().getAttribute(Constants.PROJECT_KEY);
		int p_id = project.getProject_id();


		/**
		 * //		//提交保存
		 */
		try {
			commentServiceImpl.saveComment(content, user_id, p_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		/**
		 * 评论翻页
		 */
		String pageStr = req.getParameter("page");
		Integer page;
		try{
			page = Integer.parseInt(pageStr);
		}catch(NumberFormatException e){
			page = 1;
		}
		CommentDaoImpl commentDaoImpl = new CommentDaoImpl();
		List<Comment> comments = null;
		try {
			comments = commentDaoImpl.getCommentByProject(p_id, page);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("comments", comments);
	
		
		/**
		 * 把评论列表和用户对象存放在json数组
		 */
		JSONObject json1 = JSONObject.fromObject(user);		//把用户对象存放在一个json里
//		JSONArray json = JSONArray.fromObject(comments);	//该项目所有评论放在一个json数组里	
//		json.add(json1);						//把用户这个json 放在 名字为json的json数组里
		PrintWriter out = resp.getWriter();
		out.println(json1);
		out.flush();
		
//		resp.sendRedirect("project.jhtml?id="+project_id);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

	
}
