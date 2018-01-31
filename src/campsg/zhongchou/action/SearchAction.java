package campsg.zhongchou.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import campsg.zhongchou.dao.jdbc.ProjectDaoImpl;
import campsg.zhongchou.entity.Project;



public class SearchAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String pageStr = request.getParameter("page");//当前页码

		String key = request.getParameter("key"); //搜索关键字
		String projectType = request.getParameter("projectType"); //类别
		Integer page;
		List<Project> projects = null;
		Integer count = 0;
		try{
			page = Integer.parseInt(pageStr);
		}catch(NumberFormatException e){
			page = 1;
		}
		ProjectDaoImpl pjd = new ProjectDaoImpl();
		Project project = new Project();
		project.setTitle(key);
		project.setIs_audits(2);
		if(projectType==null||projectType.equals("")){
			project.setCategory_id(0);
		}else{
			project.setCategory_id(Integer.parseInt(projectType));
		}
		
		
		try {
			count = pjd.getProjectNum(projectType,key);
			projects = pjd.getProjectByCondition(project, page,20);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("count", count);
		request.setAttribute("projects", projects);
		request.setAttribute("projectType", projectType);
	
		request.getRequestDispatcher("/search.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
}
