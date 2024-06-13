package vip.yeee.zhongchou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vip.yeee.zhongchou.entity.ProjectRepay;
import vip.yeee.zhongchou.utils.JDBCUtils;
import vip.yeee.zhongchou.utils.Packager;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ProjectRepayDao extends BaseDao {

    public void saveProjectRepay(List<ProjectRepay> projectRepays) throws SQLException {
        for (int i = 0; i < projectRepays.size(); i++) {
            String sql = "INSERT INTO projectRepay (project_id,paytitle,paycontent,type,time,money) VALUES(?,?,?,?,?,?) ";
            Object[] param = {projectRepays.get(i).getProject(),
                    projectRepays.get(i).getTitle(),
                    projectRepays.get(i).getContent(),
                    projectRepays.get(i).getType(),
                    projectRepays.get(i).getTime(),
                    projectRepays.get(i).getMoney()};

            saveOrUpdateOrDelete(sql, param);
        }

    }

    public ProjectRepay getProjectRepayById(int id) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "SELECT * FROM projectrepay WHERE id=" + id;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProjectRepay projectRepay = null;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {

                projectRepay = Packager.packProjectRepay(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return projectRepay;
    }

    public List<ProjectRepay> getProjectRepayByProjectId(int project_id)
            throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ProjectRepay> projectRepayList = new ArrayList<>();
        try {
            sql = "SELECT * FROM projectrepay WHERE project_id=" + project_id;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProjectRepay p = new ProjectRepay();
                p = Packager.packProjectRepay(rs);
                projectRepayList.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }

        return projectRepayList;
    }


}
