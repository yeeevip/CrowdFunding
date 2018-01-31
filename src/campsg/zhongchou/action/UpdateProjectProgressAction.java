package campsg.zhongchou.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import campsg.zhongchou.constant.Constants;
import campsg.zhongchou.dao.jdbc.ProjectProgressDaoImpl;
import campsg.zhongchou.entity.ProjectProgress;
import campsg.zhongchou.entity.User;

public class UpdateProjectProgressAction  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProjectProgressDaoImpl projectProgressDaoImpl = new ProjectProgressDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		String project_id = req.getParameter("projectId");
		String content = req.getParameter("content");
		
		User user = (campsg.zhongchou.entity.User) req.getSession().getAttribute(Constants.USER_KEY);
		ProjectProgress projectProgress = new ProjectProgress();
		projectProgress.setProjectId(Integer.parseInt(project_id));
		projectProgress.setContent(content);
		//projectProgress.setPublishDate(publishDate);
		projectProgress.setPubUser(user.getUser_name());
		
		try{
			projectProgressDaoImpl.insertProjectProgress(projectProgress);
			resp.getWriter().print("{\"code\":\"0\",\"msg\":\"发布成功\"}");
		}catch(Exception e){
			resp.getWriter().print("{'code':'-1','msg':'发布失败#####"+e.toString()+"'}");
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
