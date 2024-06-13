package vip.yeee.zhongchou.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.yeee.zhongchou.constant.Constants;
import vip.yeee.zhongchou.dao.UserDao;
import vip.yeee.zhongchou.entity.User;
import vip.yeee.zhongchou.utils.Utils;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ReviseUserAction extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final UserDao userDao = new UserDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //修改个人基本资料
        User user = (User) req.getSession().getAttribute(Constants.USER_KEY);
        try {
            updateUser(req, resp, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        PrintWriter out = resp.getWriter();
        if (req.getAttribute("respMessage") != null) {
            out.print(req.getAttribute("respMessage"));
        } else {
            out.print("true");
        }

        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException, SQLException {
        /**
         * 获取用户提交的信息
         */
        String sex = request.getParameter("sex");
        String user_name = request.getParameter("user_name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String real_name = request.getParameter("real_name");
        String id_number = request.getParameter("id_number");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String newPassword2 = request.getParameter("newPassword2");

        if (newPassword != null && !newPassword.equals("")) {
            if (!user.getPassword().equals(Utils.toMD5(oldPassword))) {
                request.setAttribute("respMessage", "旧密码错误");
                return;
            }
            if (!newPassword.equals(newPassword2)) {
                request.setAttribute("respMessage", "两次新密码不一致");
                return;
            }
            user.setPassword(Utils.toMD5(newPassword));
        }

        // 将数据封装到user对象
        user.setId_number(id_number);
        user.setUser_name(user_name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setReal_name(real_name);
        user.setSex(sex);


        userDao.update(user);

        // 更新后的数据保存进session
        request.getSession().setAttribute(Constants.USER_KEY, user);
    }


}
