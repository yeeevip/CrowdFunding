package com.yeah.zhongchou.service;

import java.sql.SQLException;




/** * @author https://www.yeee.vip  作者 E-mail: * @date 创建时间：2016年12月14日 下午1:42:59 * @version 1.0 * @parameter  * @since  * @return  */

/**
 * 评论服务接口类
 */
public interface CommentService {
	/**
	 * 添加评论
	 */
	void saveComment(String content,int user, int project) throws SQLException ;

}
