package com.yeah.zhongchou.dao;

import java.sql.SQLException;
import java.util.List;

import com.yeah.zhongchou.entity.Order;

/** * @author  Hacker110 * @date 2016年12月28日 下午4:30:25 * @version 1.0  */
public interface OrderDao {
	/**
	 * 创建订单
	 */
	void saveOrder(Order order) throws SQLException;
	
	/**
	 * 根据买家用户id查找订单
	 */
	List<Order> getOrderByUser_id(int user_id) throws SQLException;
	
	/**
	 * 根据卖家用户id查找订单
	 */
	List<Order> getOrderByUser_seller(int user_seller_id) throws SQLException;
	
	
	
	int updateOrder(Order order) throws SQLException;
	
	Order getOrderByid(int id) throws SQLException;

}
