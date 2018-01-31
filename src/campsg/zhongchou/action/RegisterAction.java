package campsg.zhongchou.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import campsg.zhongchou.constant.Constants;
import campsg.zhongchou.dao.jdbc.UserDaoImpl;
import campsg.zhongchou.entity.User;
import compsg.zhongchou.service.impl.UserServiceImpl;



public class RegisterAction extends HttpServlet {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	
	
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//获取用户的注册名（手机或者邮箱）
		String condition = req.getParameter("name");
		
		//System.out.println(condition);
		//获取用户注册密码
		String password = req.getParameter("password");
		
		//获取验证码
		String code = req.getParameter("code");
		
		// session域中拿到当前正确的验证码
		String right_code = (String) req.getSession().getAttribute(Constants.CHECK_NUMBER_NAME);
		
		if(condition == "" || password == "")
		{
			req.setAttribute("both_error","用户名或者密码不能为空！");
			req.getRequestDispatcher("/include/register.jsp").forward(req, resp);
			return;
			
		}
		
		try {
			if(isUserExisted(condition)){
				//设置错误信息
				//System.out.println("1111");
				req.setAttribute("err_msg", "当前账号已经存在！");
				req.getRequestDispatcher("/include/register.jsp").forward(req,resp);
				return;
			}
			

			//对验证码的正确性进行验证
			//System.out.println(right_code);
			else if(!userServiceImpl.checkCode(right_code, code)){
				req.setAttribute("code_error", "验证码不正确！");
				
				req.getRequestDispatcher("/include/register.jsp").forward(req, resp);
				return;
			}
			
			
			/*
			 * 保存用户
			 *
			 */
			else{
				//保存用户数据
			 try {
				userServiceImpl.registUser(condition,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//跳转到登陆页面
				req.getRequestDispatcher("/include/login.jsp").forward(req,resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	/**
	 * 判断当前尝试注册的用户是否存在
	 * @throws SQLException 
	 */
	private boolean isUserExisted(String condition) throws ServletException,IOException, SQLException{

		User user = userDaoImpl.getUserByCondition(condition);
		
		//对账号的唯一性进行检查
		if(user != null)
			return true;
		return false;
	}

	
	
}
