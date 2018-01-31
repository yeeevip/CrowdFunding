package campsg.zhongchou.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import campsg.zhongchou.constant.Constants;
import campsg.zhongchou.dao.jdbc.ProjectRepayDaoImpl;
import campsg.zhongchou.dao.jdbc.ReceiveInfoDaoImpl;
import campsg.zhongchou.entity.ProjectRepay;
import campsg.zhongchou.entity.ReceiveInfo;
import campsg.zhongchou.entity.User;


public class OrderPageAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer project_id = Integer.parseInt(req.getParameter("project"));
		//回报
		ProjectRepayDaoImpl projectRepayDaoImpl = new ProjectRepayDaoImpl();
		ReceiveInfoDaoImpl receiveInfoDaoImpl = new ReceiveInfoDaoImpl();
		List<ProjectRepay> pr = null;
		ReceiveInfo receiveInfo = null;
		User user = (User) req.getSession().getAttribute(Constants.USER_KEY);
		try {
			pr = projectRepayDaoImpl.getProjectRepayByProjectId(project_id);
			if(user!=null){
				receiveInfo = receiveInfoDaoImpl.getDefultReceiveInfo(user.getId(), 1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("pr", pr);
		req.setAttribute("receiveInfo", receiveInfo);
		req.getRequestDispatcher("/saveOrder.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
