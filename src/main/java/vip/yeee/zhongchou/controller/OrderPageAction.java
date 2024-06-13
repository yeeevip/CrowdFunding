package vip.yeee.zhongchou.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.yeee.zhongchou.constant.Constants;
import vip.yeee.zhongchou.dao.ProjectRepayDao;
import vip.yeee.zhongchou.dao.ReceiveInfoDao;
import vip.yeee.zhongchou.entity.ProjectRepay;
import vip.yeee.zhongchou.entity.ReceiveInfo;
import vip.yeee.zhongchou.entity.User;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class OrderPageAction extends HttpServlet {

    private final ProjectRepayDao projectRepayDao = new ProjectRepayDao();
    private final ReceiveInfoDao receiveInfoDao = new ReceiveInfoDao();

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer project_id = Integer.parseInt(req.getParameter("project"));
        //回报
        List<ProjectRepay> pr = null;
        ReceiveInfo receiveInfo = null;
        User user = (User) req.getSession().getAttribute(Constants.USER_KEY);
        try {
            pr = projectRepayDao.getProjectRepayByProjectId(project_id);
            if (user != null) {
                receiveInfo = receiveInfoDao.getDefultReceiveInfo(user.getId(), 1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("pr", pr);
        req.setAttribute("receiveInfo", receiveInfo);
        req.getRequestDispatcher("/saveOrder.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }


}
