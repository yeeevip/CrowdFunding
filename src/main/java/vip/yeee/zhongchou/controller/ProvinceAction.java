package vip.yeee.zhongchou.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import vip.yeee.zhongchou.dao.ProvinceDao;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ProvinceAction extends HttpServlet {

    private final ProvinceDao provinceDao = new ProvinceDao();

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer pid = Integer.parseInt(req.getParameter("pid"));

        try {
            JSONArray str = JSONArray.fromObject(provinceDao.queryProvinceList(pid));
            resp.getWriter().print(str.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
