package campsg.zhongchou.dao;

import java.sql.SQLException;
import java.util.List;

import campsg.zhongchou.entity.User;

public interface UserDao {
	/**
	 * 通过邮箱或者电话号码,用户名查询User
	 * 
	 * @param condition
	 *            查询关键字
	 * @return 返回User对象
	 */
	User getUserByCondition(String condition) throws Exception;
	/**
	 * 将用户对象存储到数据库
	 * 注册时只需要填写手机号或者邮箱地址
	 * 密码
	 * 所以只需插入这三个字段
	 * @param user
	 */
	void save(User user) throws SQLException;
	/**
	 * 更新或保存用户对象
	 * @param user
	 */
	void update(User user) throws SQLException;
	/**
	 * 通过用户id查找用户对象
	 * @param id 用户id
	 * @return 用户对象
	 */
	User getUserById(int id) throws SQLException;
	
	/**
	 * 根据条件查找用户，分页显示
	 */
	List<User> getUsersByCondition(String condition,Integer page) throws SQLException;



}
