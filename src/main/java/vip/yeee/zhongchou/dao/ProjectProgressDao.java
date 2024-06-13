package vip.yeee.zhongchou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vip.yeee.zhongchou.entity.ProjectProgress;
import vip.yeee.zhongchou.utils.JDBCUtils;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ProjectProgressDao extends BaseDao {

    public void insertProjectProgress(ProjectProgress projectProgress) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "INSERT INTO project_progress "
                + "(project_id,content,publish_date,pubUser)"
                + " VALUES(?,?,?,?)";
        Object[] param = {projectProgress.getProjectId(), projectProgress.getContent(), new Date(), projectProgress.getPubUser()};

        try {
            JDBCUtils.beginTransaction();
            save(sql, param, con);
            JDBCUtils.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            JDBCUtils.rollbackTransaction();

        }

    }

    public List<ProjectProgress> queryProjectProgress(Integer projectId) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ProjectProgress> projectProgressList = new ArrayList<>();
        String sql = "select * from project_progress where project_id=" + projectId + " order by publish_date desc";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProjectProgress projectProgress = new ProjectProgress();
                projectProgress.setId(rs.getInt("id"));
                projectProgress.setProjectId(rs.getInt("project_id"));
                projectProgress.setContent(rs.getString("content"));
                projectProgress.setPublishDate(rs.getString("publish_date"));
                projectProgress.setPubUser(rs.getString("pubUser"));

                projectProgressList.add(projectProgress);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return projectProgressList;
    }

}
