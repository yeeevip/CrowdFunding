package vip.yeee.zhongchou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vip.yeee.zhongchou.dao.ReceiveInfoDao;
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
public class ReceiveInfoDao extends BaseDao {

    public ReceiveInfo getReceiveInfoById(int id) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "SELECT * FROM receive_information WHERE id=" + id;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ReceiveInfo receiveInfo = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                receiveInfo = Packager.packReceiveInfo(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return receiveInfo;
    }

    public int saveReceiveInfo(ReceiveInfo receiveInfo) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "INSERT INTO receive_information (user,receiver,address,phone) VALUES(?,?,?,?)";

        ReceiveInfo defaultReceiveInfo = getDefultReceiveInfo(receiveInfo.getUser_id(), 1);

        Object[] param = {
                receiveInfo.getUser_id(),
                receiveInfo.getReceiver(),
                receiveInfo.getAddress(),
                receiveInfo.getPhone()

        };

        int r = 0;

        try {
            JDBCUtils.beginTransaction();

            r = save(sql, param, con);

            if (defaultReceiveInfo != null) {
                defaultReceiveInfo.setIs_default(0);
                updateReceiveInfo(defaultReceiveInfo);
            }

            JDBCUtils.commitTransaction();
            // r = 1;

        } catch (Exception e) {
            JDBCUtils.rollbackTransaction();
            throw e;
        } finally {
            JDBCUtils.releaseConnection(con);
        }


        return r;

    }

    public ReceiveInfo getDefultReceiveInfo(int user_id, int is_default)
            throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "SELECT * FROM receive_information WHERE user=" + user_id + " and is_default=" + is_default;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ReceiveInfo receiveInfo = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                receiveInfo = Packager.packReceiveInfo(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return receiveInfo;
    }

    public int updateReceiveInfo(ReceiveInfo receiveInfo) throws SQLException {
        // TODO Auto-generated method stub
        int r = 0;
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        PreparedStatement psuu = null;
        String sql = "UPDATE receive_information SET is_default=" + receiveInfo.getIs_default() + " where id=" + receiveInfo.getId();

        try {

            ReceiveInfo der = getDefultReceiveInfo(receiveInfo.getUser_id(), 1);

            JDBCUtils.beginTransaction();

            if (der != null) {
                String sqluu = "UPDATE receive_information SET is_default=0 where id=" + der.getId();
                psuu = con.prepareStatement(sqluu);
                psuu.executeUpdate();
            }


            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            JDBCUtils.commitTransaction();
        } catch (Exception e) {

            JDBCUtils.rollbackTransaction();

            throw e;

        } finally {
            JDBCUtils.releaseConnection(con);
        }

        return r;
    }

    public int deleteReceiveInfo(Integer id) throws SQLException {
        int r = 0;
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        String sql = "delete receive_information  where id=" + id;

        try {
            JDBCUtils.beginTransaction();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            JDBCUtils.commitTransaction();
        } catch (Exception e) {

            JDBCUtils.rollbackTransaction();

            throw e;

        } finally {
            JDBCUtils.releaseConnection(con);
        }

        return r;
    }

    public List<ReceiveInfo> queryReceiveInfos(User user) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "SELECT * FROM receive_information where 1=1";
        if (user != null) {
            sql += " and user=" + user.getId();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ReceiveInfo> receiveInfos = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReceiveInfo receiveInfo = Packager.packReceiveInfo(rs);
                receiveInfos.add(receiveInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return receiveInfos;
    }


}
