package campsg.zhongchou.dao;

import java.sql.SQLException;
import java.util.List;

import campsg.zhongchou.entity.Comment;

/** * @author  作者 E-mail: * @date 创建时间：2016年12月14日 下午1:31:56 * @version 1.0 * @parameter  * @since  * @return  */
public interface CommentDao {
	/**
	 * 根据用户得到评论
	 */
	List<Comment> getCommentByUser(int user) throws SQLException;
	
	/**
	 * 根据项目id获取总评论数
	 */
	Integer getProjectNum(int project) throws SQLException;
	
	/**
	 * 根据项目查找评论
	 */
	List<Comment> getCommentByProject(int project,Integer page) throws SQLException;
	
	/**
	 * 发表新评论
	 */
	void save(Comment comment) throws SQLException;

}
