package vip.yeee.zhongchou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vip.yeee.zhongchou.entity.Order;
import vip.yeee.zhongchou.entity.Project;
import vip.yeee.zhongchou.entity.ProjectRepay;
import vip.yeee.zhongchou.entity.ReceiveInfo;
import vip.yeee.zhongchou.entity.User;
import vip.yeee.zhongchou.utils.JDBCUtils;
import vip.yeee.zhongchou.utils.Packager;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class OrderDao extends BaseDao {

    private final UserDao userDao = new UserDao();
    private final ProjectDao projectDao = new ProjectDao();
    private final ReceiveInfoDao receiveInfoDao = new ReceiveInfoDao();
    private final ProjectRepayDao projectRepayDao = new ProjectRepayDao();

    public void saveOrder(Order order) throws SQLException {
        String sql = "INSERT INTO porder (project,user,projectrepay,count,order_date,receive_information,user_seller) VALUES(?,?,?,?,?,?,?)";

        Date date = new Date();
        SimpleDateFormat sim = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        order.setOrder_date(sim.format(date.getTime()));

        Object[] param = {
                order.getProject_id(),
                order.getUser_id(),
                order.getProjectrepay_id(),
                order.getCount(),
                order.getOrder_date(),
                order.getReceive_information(),
                order.getUser_seller_id()
        };
        saveOrUpdateOrDelete(sql, param);


    }

    public List<Order> getOrderByUser_id(int user_id) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "SELECT * FROM porder WHERE user=" + user_id + "  order by order_date desc";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList<>();
        Order order = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = Packager.packOrder(rs);
                //获得下单用户
                User user = userDao.getUserById(order.getUser_id());
                order.setUser(user);
                //获得项目
                Project project = projectDao.getProjectById(order.getProject_id());
                order.setProject(project);
                //获得卖家
                User user_seller = userDao.getUserById(order.getUser_seller_id());
                order.setUser_seller(user_seller);
                //获得回报
                ProjectRepay projectRepay = projectRepayDao.getProjectRepayById(order.getProjectrepay_id());
                order.setProjectrepay(projectRepay);

                orders.add(order);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }

        return orders;

    }

    public List<Order> getOrderByUser_seller(int user_seller_id) throws SQLException {
        String sql = "SELECT * FROM porder WHERE user_seller=" + user_seller_id;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = JDBCUtils.getConnection();
        List<Order> orders = new ArrayList<>();
        Order order = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                order = Packager.packOrder(rs);


                //获得下单用户
                User user = userDao.getUserById(order.getUser_id());
                order.setUser(user);
                //获得卖家用户
                User user_seller = userDao.getUserById(order.getUser_seller_id());
                order.setUser_seller(user_seller);
                //获得项目
                Project project = projectDao.getProjectById(order.getProject_id());
                order.setProject(project);
                //获得收货地址
                ReceiveInfo receiveInfo = receiveInfoDao.getReceiveInfoById(order.getReceive_information());
                order.setReceiveInfo(receiveInfo);
                //获得回报
                ProjectRepay projectRepay = projectRepayDao.getProjectRepayById(order.getProjectrepay_id());
                order.setProjectrepay(projectRepay);
                orders.add(order);
            }

        } catch (SQLException e) {
            throw e;

        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return orders;
    }

    public int updateOrder(Order order) throws SQLException {
        String sql = "UPDATE porder SET is_pay=?, payPrice=? where id=" + order.getId();

        try {

            JDBCUtils.beginTransaction();

            Project p = projectDao.getProjectById(order.getProject_id());
            p.setHas_fund_raising((projectRepayDao.getProjectRepayById(order.getProjectrepay_id()).getMoney()) * order.getCount() + p.getHas_fund_raising());
            projectDao.updateProject(p);

            Object[] param = {
                    order.getIs_pay(),
                    (projectRepayDao.getProjectRepayById(order.getProjectrepay_id()).getMoney()) * order.getCount()
            };
            saveOrUpdateOrDelete(sql, param);
            JDBCUtils.commitTransaction();

        } catch (Exception e) {
            JDBCUtils.rollbackTransaction();
            throw e;
        }


        return 1;
    }

    public Order getOrderByid(int id) throws SQLException {

        Connection con = JDBCUtils.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Order order = null;


        String sql = "SELECT * FROM porder u WHERE u.id = " + id;
        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            //System.out.println("1");
            if (rs.next()) {

                order = Packager.packOrder(rs);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return order;
    }

}
