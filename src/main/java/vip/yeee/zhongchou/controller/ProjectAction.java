package vip.yeee.zhongchou.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vip.yeee.zhongchou.constant.Constants;
import vip.yeee.zhongchou.dao.CommentDao;
import vip.yeee.zhongchou.dao.ProjectDao;
import vip.yeee.zhongchou.dao.ProjectProgressDao;
import vip.yeee.zhongchou.entity.Comment;
import vip.yeee.zhongchou.entity.Project;
import vip.yeee.zhongchou.entity.ProjectProgress;
import vip.yeee.zhongchou.entity.ProjectRepay;
import vip.yeee.zhongchou.entity.ProjectDetail;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ProjectAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final ProjectDao projectDao = new ProjectDao();
    private final ProjectProgressDao projectProgressDao = new ProjectProgressDao();
    private final CommentDao commentDao = new CommentDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //项目id
        String project_id = request.getParameter("id");
        Integer id = -1;
        try {
            id = Integer.parseInt(project_id);
        } catch (NumberFormatException e) {
            //如果参数不合法，则跳转到首页
            response.sendRedirect("index.jhtml");
            return;
        }
        ;

        Project p = null;
        List<ProjectProgress> pp = null;
        try {
            pp = projectProgressDao.queryProjectProgress(id);

            p = projectDao.getProjectById(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.setAttribute("p", p);
        List<ProjectDetail> pd = p.getProjectdetail();
        request.setAttribute("pd", pd);
        List<ProjectRepay> pr = p.getProjectRepay();
        request.setAttribute("pr", pr);


        request.setAttribute("pp", pp);
		
/*		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User lunchUser = null;
		try {
			lunchUser = userDaoImpl.getUserById(p.getUser_id());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.setAttribute("lunchUser", lunchUser.getId());*/


        //评论数据

        int page = 1;

        List<Comment> comments = null;
        try {
            comments = commentDao.getCommentByProject(id, page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("comments", comments);
        //System.out.println("-----"+comments.toString());
        //System.out.println(comments.get(0).getUser());
//		JSONObject json = new JSONObject().fromObject(comments);


        HttpSession session = request.getSession();
        session.setAttribute(Constants.PROJECT_KEY, p);

        request.getRequestDispatcher("/project.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        doGet(request, response);
    }

}
