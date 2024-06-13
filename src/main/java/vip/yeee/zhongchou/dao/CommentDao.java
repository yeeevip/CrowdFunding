package vip.yeee.zhongchou.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import vip.yeee.zhongchou.entity.Comment;
import vip.yeee.zhongchou.entity.User;
import vip.yeee.zhongchou.utils.JDBCUtils;
import vip.yeee.zhongchou.utils.Packager;


/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class CommentDao extends BaseDao {

    public List<Comment> getCommentByUser(int user) {
        return null;
    }


    public Integer getProjectNum(int project) throws SQLException {

        String sql = "SELECT count(*) FROM comment WHERE project=" + project;
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next())
                count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }

        return count;
    }


    public List<Comment> getCommentByProject(int project, Integer page) throws SQLException {
        // TODO Auto-generated method stub

        StringBuffer sql = new StringBuffer("SELECT * FROM comment WHERE project = " + project);
        sql.append(" order by time desc");
        int max = 5; //单页最大显示数
        int start = (page - 1) * max;
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet user_rs = null;
        List<Comment> comments = new ArrayList<>();
        Comment comment = null;
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setMaxRows(start + max);
            rs = ps.executeQuery();
            rs.first();
            rs.relative(start - 1);

            while (rs.next()) {
                //封装保存Comment对象
                comment = Packager.packComment(rs);
                //封装保存用户对象
                String user_sql = "SELECT * FROM user WHERE id = " + comment.getUser_id();
                ps = con.prepareStatement(user_sql);
                user_rs = ps.executeQuery();
                User user = null;
                if (user_rs.next()) {
                    user = Packager.packUser(user_rs);
                }
                comment.setUser(user);

                //保存comment列表
                comments.add(comment);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }

        return comments;
    }


    public void save(Comment comment) throws SQLException {
        // TODO Auto-generated method stub

        String sql = "INSERT INTO comment (user_id,project,content,time) VALUES(?,?,?,?)";
        Object[] param = {comment.getUser_id(), comment.getProject(), comment.getContent(), comment.getTime()};
        saveOrUpdateOrDelete(sql, param);

    }


}
