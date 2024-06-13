package vip.yeee.zhongchou.service;

import java.sql.SQLException;
import java.util.Date;

import vip.yeee.zhongchou.dao.CommentDao;

import vip.yeee.zhongchou.entity.Comment;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class CommentService {

    private final CommentDao commentDao = new CommentDao();

    public void saveComment(String content, int user, int project) throws SQLException {
        Comment comment = new Comment();
        comment.setUser_id(user);
        comment.setProject(project);
        comment.setContent(content);
        comment.setTime(new Date());
        commentDao.save(comment);
    }

}
