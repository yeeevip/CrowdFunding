package vip.yeee.zhongchou.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.yeee.zhongchou.dao.ProjectDao;
import vip.yeee.zhongchou.entity.Project;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class SearchAction extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final ProjectDao projectDao = new ProjectDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String pageStr = request.getParameter("page");//当前页码

        String key = request.getParameter("key"); //搜索关键字
        String projectType = request.getParameter("projectType"); //类别
        Integer page;
        List<Project> projects = null;
        Integer count = 0;
        try {
            page = Integer.parseInt(pageStr);
        } catch (NumberFormatException e) {
            page = 1;
        }

        Project project = new Project();
        project.setTitle(key);
        project.setIs_audits(1);
        if (projectType == null || projectType.equals("")) {
            project.setCategory_id(0);
        } else {
            project.setCategory_id(Integer.parseInt(projectType));
        }


        try {
            count = projectDao.getProjectNum(projectType, key);
            projects = projectDao.getProjectByCondition(project, page, 20);
        } catch (SQLException e) {
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
