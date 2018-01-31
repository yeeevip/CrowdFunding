package compsg.zhongchou.service.impl;

import java.sql.SQLException;

import com.zhongchou.service.CommentService;

import campsg.zhongchou.dao.jdbc.CommentDaoImpl;
import campsg.zhongchou.entity.Comment;



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
		commentDaoImpl.save(comment);
	}

}
