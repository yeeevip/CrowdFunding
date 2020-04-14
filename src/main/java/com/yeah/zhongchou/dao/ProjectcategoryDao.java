package com.yeah.zhongchou.dao;

import java.sql.SQLException;

import com.yeah.zhongchou.entity.Projectcategory;

/** * @author  作者 E-mail: * @date 创建时间：2016年12月15日 下午6:08:37 * @version 1.0 * @parameter  * @since  * @return  */
public interface ProjectcategoryDao {
	
	/**
	 * 通过类别id查找
	 */
	Projectcategory getcategoryById(int id) throws SQLException;

}
