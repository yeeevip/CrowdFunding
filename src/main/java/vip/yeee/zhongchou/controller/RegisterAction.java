package vip.yeee.zhongchou.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.yeee.zhongchou.constant.Constants;
import vip.yeee.zhongchou.dao.UserDao;
import vip.yeee.zhongchou.entity.User;
import vip.yeee.zhongchou.service.UserService;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class RegisterAction extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final UserService userService = new UserService();

    private final UserDao userDao = new UserDao();

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

        if (Objects.equals(condition, "") || Objects.equals(password, "")) {
            req.setAttribute("both_error", "用户名或者密码不能为空！");
            req.getRequestDispatcher("/include/register.jsp").forward(req, resp);
            return;

        }

        try {
            if (isUserExisted(condition)) {
                //设置错误信息
                //System.out.println("1111");
                req.setAttribute("err_msg", "当前账号已经存在！");
                req.getRequestDispatcher("/include/register.jsp").forward(req, resp);
                return;
            }


            //对验证码的正确性进行验证
            //System.out.println(right_code);
            else if (!userService.checkCode(right_code, code)) {
                req.setAttribute("code_error", "验证码不正确！");

                req.getRequestDispatcher("/include/register.jsp").forward(req, resp);
                return;
            }


            /*
             * 保存用户
             *
             */
            else {
                //保存用户数据
                try {
                    userService.registerUser(condition, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //跳转到登陆页面
                req.getRequestDispatcher("/include/login.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 判断当前尝试注册的用户是否存在
     *
     * @throws SQLException
     */
    private boolean isUserExisted(String condition) throws ServletException, IOException, SQLException {

        User user = userDao.getUserByCondition(condition);

        //对账号的唯一性进行检查
        if (user != null)
            return true;
        return false;
    }


}
