package vip.yeee.zhongchou.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import vip.yeee.zhongchou.entity.Comment;
import vip.yeee.zhongchou.entity.InitiatorCompanyInfo;
import vip.yeee.zhongchou.entity.InitiatorPersonInfo;
import vip.yeee.zhongchou.entity.Order;
import vip.yeee.zhongchou.entity.Project;
import vip.yeee.zhongchou.entity.ProjectRepay;
import vip.yeee.zhongchou.entity.ProjectCategory;
import vip.yeee.zhongchou.entity.ProjectDetail;
import vip.yeee.zhongchou.entity.ReceiveInfo;
import vip.yeee.zhongchou.entity.User;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class Packager {

    public static Project packProject(ResultSet rs) throws SQLException {
        Project project = new Project();
        project.setProject_id(rs.getInt("project_id"));
        project.setTitle(rs.getString("title"));
        project.setBlurb(rs.getString("blurb"));
        project.setImg_name(rs.getString("img_name"));
        project.setTotal_fund_raising(rs.getInt("total_fund_raising"));
        project.setHas_fund_raising(rs.getInt("has_fund_raising"));
        project.setDays_raising(rs.getInt("days_raising"));
        project.setIs_index(rs.getInt("is_index"));
        project.setCategory_id(rs.getInt("category_id"));
        project.setIs_audits(rs.getInt("is_audits"));
        project.setUser_id(rs.getInt("user_id"));
        project.setLaunch_date(rs.getString("launch_date_raising"));
        project.setShenfen(rs.getString("shenfen"));
        project.setIs_finish(rs.getInt("is_finish"));

        return project;
    }

    public static ProjectDetail packProjectdetail(ResultSet rs) throws SQLException {
        ProjectDetail pd = new ProjectDetail();


        pd.setTitle(rs.getString("dtitle"));
        pd.setContent(rs.getString("dcontent"));
        return pd;
    }

    /**
     * 封装User普通属性
     */
    public static User packUser(ResultSet rs) throws SQLException {

        User user = new User();
        user.setId(rs.getInt("id"));
        user.setDate_of_registration(rs.getString("date_of_registration"));
        user.setId_number(rs.getString("id_number"));
        user.setSex(rs.getString("sex"));
        user.setReal_name(rs.getString("real_name"));
        user.setUser_name(rs.getString("user_name"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        user.setPassword(rs.getString("password"));
        return user;
    }

    /**
     * 封装评论属性
     */
    public static Comment packComment(ResultSet rs) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getInt("id"));
        comment.setUser_id(rs.getInt("user_id"));
        comment.setProject(rs.getInt("project"));
        comment.setContent(rs.getString("content"));
        comment.setTime(rs.getDate("time"));
        return comment;
    }

    /**
     * 封装项目类别属性
     */
    public static ProjectCategory packProjectcategory(ResultSet rs) throws SQLException {

        ProjectCategory projectcategory = new ProjectCategory();
        projectcategory.setId(rs.getInt("id"));
        projectcategory.setCategory_name(rs.getString("category_name"));
        projectcategory.setNote(rs.getString("note"));
        projectcategory.setChange_person(rs.getString("change_person"));
        return projectcategory;
    }

    /**
     * 收货地址
     */
    public static ReceiveInfo packReceiveInfo(ResultSet rs) throws SQLException {
        ReceiveInfo receiveInfo = new ReceiveInfo();
        receiveInfo.setIs_default(rs.getInt("is_default"));
        receiveInfo.setReceiver(rs.getString("receiver"));
        receiveInfo.setAddress(rs.getString("address"));
        receiveInfo.setPhone(rs.getString("phone"));
        receiveInfo.setId(rs.getInt("id"));
        return receiveInfo;
    }

    /**
     * 回报
     */
    public static ProjectRepay packProjectRepay(ResultSet rs) throws SQLException {
        ProjectRepay projectRepay = new ProjectRepay();
        projectRepay.setId(rs.getInt("id"));
        projectRepay.setTitle(rs.getString("paytitle"));
        projectRepay.setContent(rs.getString("paycontent"));
        projectRepay.setMoney(rs.getInt("money"));
        projectRepay.setTime(rs.getInt("time"));
        projectRepay.setType(rs.getString("type"));
        return projectRepay;

    }

    /**
     * 订单
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Order packOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrder_date(rs.getString("order_date"));
        order.setCount(rs.getInt("count"));
        order.setIs_pay(rs.getInt("is_pay"));
        order.setIs_send(rs.getInt("is_send"));
        order.setId(rs.getInt("id"));
        order.setUser_id(rs.getInt("user"));
        order.setProject_id(rs.getInt("project"));
        order.setProjectrepay_id(rs.getInt("projectrepay"));
        order.setUser_seller_id(rs.getInt("user_seller"));
        order.setReceive_information(rs.getInt("receive_information"));
        order.setPayPrice(rs.getFloat("payPrice"));
        return order;
    }

    /**
     * 个人
     */
    public static InitiatorPersonInfo packInitiatorP(ResultSet rs) throws SQLException {
        InitiatorPersonInfo initiatorPersonInfo = new InitiatorPersonInfo();
        initiatorPersonInfo.setName(rs.getString("name"));
        initiatorPersonInfo.setIDnumber(rs.getString("IDnumber"));
        initiatorPersonInfo.setPhone(rs.getString("phone"));
        initiatorPersonInfo.setSzimg(rs.getString("IDpicFace"));
        initiatorPersonInfo.setSfimg(rs.getString("IDpicInverse"));
        return initiatorPersonInfo;
    }

    /**
     * 企业
     */
    public static InitiatorCompanyInfo packInitiatorC(ResultSet rs) throws SQLException {
        InitiatorCompanyInfo initiatorCompanyInfo = new InitiatorCompanyInfo();
        initiatorCompanyInfo.setFirmName(rs.getString("firmName"));
        initiatorCompanyInfo.setBusinessNumber(rs.getString("businessNumber"));
        initiatorCompanyInfo.setAddress(rs.getString("address"));
        initiatorCompanyInfo.setContactName(rs.getString("contactName"));
        initiatorCompanyInfo.setContactPhone(rs.getString("contactPhone"));
        initiatorCompanyInfo.setSlanderName(rs.getString("slanderName"));
        initiatorCompanyInfo.setLicenesPic(rs.getString("licenesPic"));
        initiatorCompanyInfo.setRegisteredNumPic(rs.getString("registeredNumPic"));
        initiatorCompanyInfo.setTaxPig(rs.getString("taxPig"));
        return initiatorCompanyInfo;
    }
}
