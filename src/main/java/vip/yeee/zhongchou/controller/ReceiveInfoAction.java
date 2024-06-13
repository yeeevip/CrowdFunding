package vip.yeee.zhongchou.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.yeee.zhongchou.constant.Constants;
import vip.yeee.zhongchou.dao.ReceiveInfoDao;
import vip.yeee.zhongchou.entity.ReceiveInfo;
import vip.yeee.zhongchou.entity.User;
import net.sf.json.JSONArray;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ReceiveInfoAction extends HttpServlet {

    private final ReceiveInfoDao receiveInfoDao = new ReceiveInfoDao();

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String path = req.getRequestURI();
        String action = path.substring(path.lastIndexOf("/"));
        User user = (User) req.getSession().getAttribute(Constants.USER_KEY);

        if (action.equals("/ReceiveInfoPage")) {
            req.getRequestDispatcher("/receiveInfoForm.jsp").forward(req, resp);
        }


        if (action.equals("/setDefaultReceiveInfo")) {
            String receiveId = req.getParameter("receiveId");

            try {
                ReceiveInfo receiveInfo = receiveInfoDao.getReceiveInfoById(Integer.parseInt(receiveId));
                receiveInfo.setIs_default(1);
                receiveInfo.setUser_id(user.getId());
                receiveInfoDao.updateReceiveInfo(receiveInfo);
                resp.getWriter().print("{\"code\":\"0\",\"msg\":\"设置成功\"}");
            } catch (SQLException e) {
                e.printStackTrace();
                resp.getWriter().print("{'code':'-1','msg':'设置失败#####" + e.toString() + "'}");
            }
        }


        if (action.equals("/addReceiveInfo")) {

            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            String receiver = req.getParameter("receiver");
            String is_defult = req.getParameter("is_defult");

            ReceiveInfo receiveInfo = new ReceiveInfo();
            receiveInfo.setUser_id(user.getId());
            receiveInfo.setPhone(phone);
            receiveInfo.setAddress(address);
            receiveInfo.setReceiver(receiver);
            //receiveInfo.setIs_defult(Integer.parseInt(is_defult));

            try {
                receiveInfoDao.saveReceiveInfo(receiveInfo);
                resp.getWriter().print("{\"code\":\"0\",\"msg\":\"添加成功\"}");
            } catch (SQLException e) {
                e.printStackTrace();
                resp.getWriter().print("{'code':'-1','msg':'添加失败#####" + e.toString() + "'}");
            }


        }
        if (action.equals("/deleteReceiveInfo")) {
            String rId = req.getParameter("id");

            try {

                receiveInfoDao.deleteReceiveInfo(Integer.parseInt(rId));
                resp.getWriter().print("{\"code\":\"0\",\"msg\":\"删除成功\"}");

            } catch (Exception e) {
                e.printStackTrace();
                resp.getWriter().print("{'code':'-1','msg':'删除失败#####" + e.toString() + "'}");
            }

        }
        if (action.equals("/queryReceiveInfo")) {
            List<ReceiveInfo> receiveInfos = null;
            try {
                receiveInfos = receiveInfoDao.queryReceiveInfos(user);
                req.setAttribute("receiveInfos", receiveInfos);
                resp.getWriter().print(JSONArray.fromObject(receiveInfos));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
