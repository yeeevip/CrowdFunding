package vip.yeee.zhongchou.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.yeee.zhongchou.constant.Constants;
import vip.yeee.zhongchou.dao.OrderDao;
import vip.yeee.zhongchou.dao.ReceiveInfoDao;
import vip.yeee.zhongchou.entity.Order;
import vip.yeee.zhongchou.entity.Project;
import vip.yeee.zhongchou.entity.ReceiveInfo;
import vip.yeee.zhongchou.entity.User;
import net.sf.json.JSONArray;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class OrderAction extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final OrderDao orderDao = new OrderDao();
    private final ReceiveInfoDao receiveInfoDao = new ReceiveInfoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String reqPath = req.getRequestURI();
        String action = reqPath.substring(reqPath.lastIndexOf("/"));

        User user = (User) req.getSession().getAttribute(Constants.USER_KEY);
        int user_id = user.getId();

        if (action.equals("/saveOrder.jhtml")) {
            String responseStr = "订单提交成功！！";

            Project project = (Project) req.getSession().getAttribute(Constants.PROJECT_KEY);
            int project_id = project.getProject_id();
            int user_seller_id = project.getUser_id();
            int count = Integer.parseInt(req.getParameter("pay_count"));
            int projectRepay_id = Integer.parseInt(req.getParameter("projectRepay_id"));
            String is_defaultReceive = req.getParameter("is_defaultReceive");


            int receiveInfo_id = 0;
            if (is_defaultReceive != null && is_defaultReceive.equals("0")) {
                String receiver = req.getParameter("receiver");
                String address = req.getParameter("address");
                String phone = req.getParameter("phone");
                //保存收货
                ReceiveInfo receiveInfo = new ReceiveInfo();
                receiveInfo.setUser_id(user_id);
                receiveInfo.setReceiver(receiver);
                receiveInfo.setAddress(address);
                receiveInfo.setPhone(phone);

                try {
                    receiveInfo_id = receiveInfoDao.saveReceiveInfo(receiveInfo);
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            } else {
                try {
                    receiveInfo_id = receiveInfoDao.getDefultReceiveInfo(user_id, 1).getId();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            Order order = new Order();
            order.setUser_id(user_id);//下单者
            order.setProject_id(project_id);
            order.setUser_seller_id(user_seller_id);//卖家
            order.setCount(count);//下单数量
            order.setProjectrepay_id(projectRepay_id);
            order.setReceive_information(receiveInfo_id);
            ;//收货地址

            try {
                orderDao.saveOrder(order);

                resp.getWriter().print("{\"code\":\"0\",\"msg\":\"订单提交成功！！\"}");

            } catch (SQLException e) {
                e.printStackTrace();
                resp.getWriter().print("{'code':'-1','msg':'订单提交失败！！#####" + e.toString() + "'}");
            }

            //resp.getWriter().print(responseStr);

        }
        if (action.equals("/buyerOrder.jhtml")) {

            List<Order> orders = null;
            try {
                orders = orderDao.getOrderByUser_id(user_id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("1+++" + orders.toString());
            //放入json数组
            JSONArray Ojson = JSONArray.fromObject(orders);
            PrintWriter out = resp.getWriter();
            out.print(Ojson);

        }
        if (action.equals("/sellerOrder.jhtml")) {

            List<Order> orders = null;
            try {
                orders = orderDao.getOrderByUser_seller(user_id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("2+++" + orders.toString());
            //放入json
            JSONArray Ojson = JSONArray.fromObject(orders);

            PrintWriter out = resp.getWriter();
            out.print(Ojson);
        }


        if (action.equals("/toPay")) {
            String order_id = req.getParameter("order_id");

            try {
                Order o = orderDao.getOrderByid(Integer.parseInt(order_id));
                o.setIs_pay(1);
                //o.setId(Integer.parseInt(order_id));
                orderDao.updateOrder(o);
                resp.getWriter().print("{\"code\":\"0\",\"msg\":\"付款成功！！\"}");
            } catch (Exception e) {
                e.printStackTrace();
                resp.getWriter().print("{\"code\":\"-1\",\"msg\":\"付款失败！！#####" + e.toString() + "\"}");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
