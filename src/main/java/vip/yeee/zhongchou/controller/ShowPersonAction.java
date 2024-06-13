package vip.yeee.zhongchou.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.yeee.zhongchou.constant.Constants;
import vip.yeee.zhongchou.dao.ProjectDao;
import vip.yeee.zhongchou.entity.Project;
import vip.yeee.zhongchou.entity.User;
import net.sf.json.JSONArray;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ShowPersonAction extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final ProjectDao projectDao = new ProjectDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");

        String path = req.getRequestURI();
        String action = path.substring(path.lastIndexOf("/"));


        Integer currentPage = Integer.parseInt(req.getParameter("currentPage") == null ? "1" : req.getParameter("currentPage"));


        //从session中获取当前登录用户
        User user = (User) req.getSession().getAttribute(Constants.USER_KEY);
        req.setAttribute("user", user);

        int user_id = user.getId();
        List<Project> projects = null;

        Project project = new Project();
        project.setUser_id(user_id);

        Integer pageCount = 0;


        try {
            projects = projectDao.getProjectByCondition(project, currentPage, 4);
            pageCount = (int) Math.ceil(projectDao.getProjectByUser_id(user_id) / 4);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        req.setAttribute("pageCount", pageCount);
        req.setAttribute("projects", projects);

        if (action.equals("/showPerson.jhtml")) {
            req.getRequestDispatcher("/personal_information.jsp").forward(req, resp);
        }
        if (action.equals("/getMyProjectPageShow")) {
            resp.getWriter().print(JSONArray.fromObject(projects));
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
