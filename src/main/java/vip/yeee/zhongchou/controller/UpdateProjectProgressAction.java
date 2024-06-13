package vip.yeee.zhongchou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.yeee.zhongchou.constant.Constants;
import vip.yeee.zhongchou.dao.ProjectProgressDao;
import vip.yeee.zhongchou.entity.ProjectProgress;
import vip.yeee.zhongchou.entity.User;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class UpdateProjectProgressAction extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final ProjectProgressDao projectProgressDao = new ProjectProgressDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String project_id = req.getParameter("projectId");
        String content = req.getParameter("content");

        User user = (User) req.getSession().getAttribute(Constants.USER_KEY);
        ProjectProgress projectProgress = new ProjectProgress();
        projectProgress.setProjectId(Integer.parseInt(project_id));
        projectProgress.setContent(content);
        //projectProgress.setPublishDate(publishDate);
        projectProgress.setPubUser(user.getUser_name());

        try {
            projectProgressDao.insertProjectProgress(projectProgress);
            resp.getWriter().print("{\"code\":\"0\",\"msg\":\"发布成功\"}");
        } catch (Exception e) {
            resp.getWriter().print("{'code':'-1','msg':'发布失败#####" + e.toString() + "'}");

            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }


}
