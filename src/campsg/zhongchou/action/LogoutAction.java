package campsg.zhongchou.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** * @author  作者 E-mail: * @date 创建时间：2016年12月14日 上午11:03:34 * @version 1.0 * @parameter  * @since  * @return  */
public class LogoutAction extends HttpServlet {

	private static final long serialVersionUID = 2149515480031549266L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//强制销毁session
		req.getSession().invalidate();
		//跳转首页
		resp.sendRedirect(req.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	

}
