package vip.yeee.zhongchou.controller;

import java.io.IOException;


import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vip.yeee.zhongchou.constant.Constants;
import vip.yeee.zhongchou.dao.UserDao;
import vip.yeee.zhongchou.entity.User;
import vip.yeee.zhongchou.service.UserService;
import vip.yeee.zhongchou.utils.Utils;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class LoginAction extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String ERROR_URL;    //登录失败的跳转url
    private String OK_URL;    //登录成功跳转的url
    private final UserDao userDao = new UserDao();
    private final UserService userService = new UserService();

    public void init() throws ServletException {
        super.init();
        ERROR_URL = super.getServletConfig().getInitParameter("error_url");
        OK_URL = super.getServletConfig().getInitParameter("index_url");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用户提交的手机或者邮箱
        String condition = request.getParameter("name");
        //个人密码
        String password = request.getParameter("password");
        //用户输入的验证码
        String code = request.getParameter("code");

        //如果用户名、密码或者验证码为空则跳会登陆页面
        if (Objects.equals(condition, "") || Objects.equals(password, "")) {
            request.setAttribute("both_error", "请输入用户名或者密码！");
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
            return;
        }


        // session域中拿到当前正确的验证码
        String right_code = (String) request.getSession().getAttribute(Constants.CHECK_NUMBER_NAME);
        //对验证码的正确性进行验证
        if (!userService.checkCode(right_code, code)) {
            request.setAttribute("code_error", "验证码不正确！");

            request.getRequestDispatcher(ERROR_URL).forward(request, response);
            return;
        }

        //通过用户名查询用户

        User user = null;
        try {
            user = userDao.getUserByCondition(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //验证用户名和密码是否真确
        if (user == null || !user.getPassword().equals(Utils.toMD5(password))) {
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

        if (re != null && !re.equals("")) {
            response.sendRedirect(re);
            return;
        } else
            //登陆成功，进行跳转
            response.sendRedirect(OK_URL);


//	request.getRequestDispatcher(OK_URL).forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}