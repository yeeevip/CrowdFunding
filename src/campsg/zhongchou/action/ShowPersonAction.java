package campsg.zhongchou.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import campsg.zhongchou.constant.Constants;
import campsg.zhongchou.dao.jdbc.ProjectDaoImpl;
import campsg.zhongchou.entity.Project;
import campsg.zhongchou.entity.User;

/** * @author  作者 E-mail: * @date 创建时间：2016年12月16日 上午11:56:35 * @version 1.0 * @parameter  * @since  * @return  */
public class ShowPersonAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("utf-8");
		
		String path = req.getRequestURI();
		String action = path.substring(path.lastIndexOf("/"));
		
		
		Integer currentPage = Integer.parseInt(req.getParameter("currentPage")==null?"1":req.getParameter("currentPage"));
		
		
		
		//从session中获取当前登录用户
		User user =(User)req.getSession().getAttribute(Constants.USER_KEY);
		req.setAttribute("user", user);
		
		int user_id = user.getId();
		List<Project> projects = null;
		
		Project project = new Project();
		project.setUser_id(user_id);
		
		Integer pageCount = 0;
		
		
		
		
		try {
			projects = projectDaoImpl.getProjectByCondition(project, currentPage, 4);
		    pageCount = (int) Math.ceil(projectDaoImpl.getProjectByUser_id(user_id)/4);
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("projects", projects);
		
		if(action.equals("/showPerson.jhtml")){
			req.getRequestDispatcher("/personal_information.jsp").forward(req, resp);
			}
		if(action.equals("/getMyProjectPageShow")){resp.getWriter().print(JSONArray.fromObject(projects));}
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	

}
