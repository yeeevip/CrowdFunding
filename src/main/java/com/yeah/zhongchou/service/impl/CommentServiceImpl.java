package com.yeah.zhongchou.service.impl;

import java.sql.SQLException;
import java.util.Date;

import com.yeah.zhongchou.service.CommentService;

import com.yeah.zhongchou.dao.jdbc.CommentDaoImpl;
import com.yeah.zhongchou.entity.Comment;



/** * @author  作者 E-mail: * @date 创建时间：2016年12月14日 下午1:47:21 * @version 1.0 * @parameter  * @since  * @return  */
public class CommentServiceImpl implements CommentService {

	private CommentDaoImpl commentDaoImpl = new CommentDaoImpl();
	@Override
	public void saveComment(String content, int user, int project) throws SQLException {
		// TODO Auto-generated method stub
		Comment comment = new Comment();
		comment.setUser_id(user);
		comment.setProject(project);
		comment.setContent(content);
		comment.setTime(new Date());
		commentDaoImpl.save(comment);
	}

}
