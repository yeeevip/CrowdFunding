package campsg.zhongchou.action;

import java.io.IOException;


import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import campsg.zhongchou.constant.Constants;
import campsg.zhongchou.dao.jdbc.UserDaoImpl;
import campsg.zhongchou.entity.User;
import campsg.zhongchou.utils.Untils;
import compsg.zhongchou.service.impl.UserServiceImpl;





public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	

  private String ERROR_URL;	//登录失败的跳转url
  private String OK_URL;	//登录成功跳转的url
  private UserDaoImpl userDaoImpl = new UserDaoImpl();  
  private UserServiceImpl userServiceImpl = new UserServiceImpl();
   	
 public void init() throws ServletException{
	 	super.init();
        ERROR_URL=super.getServletConfig().getInitParameter("error_url");
        OK_URL=super.getServletConfig().getInitParameter("index_url");
        	
        }
    

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//用户提交的手机或者邮箱
	String condition=request.getParameter("name");
	//个人密码
	String password=request.getParameter("password");
	//用户输入的验证码
	String code = request.getParameter("code");
	
	//如果用户名、密码或者验证码为空则跳会登陆页面
	if(condition == "" || password == "")
	{
		request.setAttribute("both_error","请输入用户名或者密码！");
		request.getRequestDispatcher(ERROR_URL).forward(request, response);
		return;
		
	}

	
	
	// session域中拿到当前正确的验证码
	String right_code = (String) request.getSession().getAttribute(Constants.CHECK_NUMBER_NAME);
	//对验证码的正确性进行验证
	if(!userServiceImpl.checkCode(right_code, code)){
		request.setAttribute("code_error", "验证码不正确！");
		
		request.getRequestDispatcher(ERROR_URL).forward(request, response);
		return;
	}
	
	
	//通过用户名查询用户
	
	User user = null;
	try {
		user = userDaoImpl.getUserByCondition(condition);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//验证用户名和密码是否真确
	if(user == null || !user.getPassword().equals(Untils.toMD5(password))){
		request.setAttribute("user_error", "用户名或者密码错误！");
		request.getRequestDispatcher(ERROR_URL).forward(request, response);
		return;
	}
	
		//session 登陆用户
	HttpSession session = request.getSession();
	request.getSession().setMaxInactiveInterval(1800);/*秒为单位*/  
	session.setAttribute("user", user);
	
	//过滤器  登陆成功后跳转当前页
	String re = request.getParameter("re");
	
	if(re != null && !re.equals("")){
		response.sendRedirect(re);
		return;
	}else
		//登陆成功，进行跳转
		response.sendRedirect(OK_URL);



//	request.getRequestDispatcher(OK_URL).forward(request, response);
	
}


/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doGet(request, response);
}

}