package vip.yeee.zhongchou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vip.yeee.zhongchou.entity.InitiatorCompanyInfo;
import vip.yeee.zhongchou.entity.InitiatorPersonInfo;
import vip.yeee.zhongchou.utils.JDBCUtils;
import vip.yeee.zhongchou.utils.Packager;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class InitiatorInfoDao extends BaseDao {

    public void saveInitiatorPersonInfo(InitiatorPersonInfo initiatorPersonInfo) throws SQLException {
        String sql = "INSERT INTO initiator_personInfo (project,name,IDnumber,phone) VALUES(?,?,?,?)";
        Object[] param = {initiatorPersonInfo.getProject_id(), initiatorPersonInfo.getName(), initiatorPersonInfo.getIDnumber(), initiatorPersonInfo.getPhone()};
        saveOrUpdateOrDelete(sql, param);

    }

    public void saveInitiatorCompanyInfo(InitiatorCompanyInfo initiatorCompanyInfo) throws SQLException {
        String sql = "INSERT INTO initiator_companyInfo (project,firmName,businessNumber,slanderName,address,contactName,contactPhone) VALUES(?,?,?,?,?,?,?)";
        Object[] param = {initiatorCompanyInfo.getProject_id(),
                initiatorCompanyInfo.getFirmName(),
                initiatorCompanyInfo.getBusinessNumber(),
                initiatorCompanyInfo.getSlanderName(),
                initiatorCompanyInfo.getAddress(),
                initiatorCompanyInfo.getContactName(),
                initiatorCompanyInfo.getContactPhone()
        };
        saveOrUpdateOrDelete(sql, param);
    }

    public InitiatorPersonInfo getInitiatorPersonInfoByProject_id(int project_id) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "SELECT * FROM initiator_personinfo WHERE project=" + project_id;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InitiatorPersonInfo initiatorP = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                initiatorP = Packager.packInitiatorP(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return initiatorP;
    }

    public InitiatorCompanyInfo getInitiatorCompanyInfoByProject_id(int project_id) throws SQLException {

        Connection con = JDBCUtils.getConnection();
        String sql = "SELECT * FROM initiator_companyinfo WHERE project =" + project_id;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InitiatorCompanyInfo initiatorC = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                initiatorC = Packager.packInitiatorC(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return initiatorC;
    }

}
