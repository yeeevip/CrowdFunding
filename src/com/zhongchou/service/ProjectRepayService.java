package com.zhongchou.service;import java.sql.SQLException;

/** * @author  Hacker110 * @date 2016年12月18日 下午4:22:43 * @version 1.0  */
public interface ProjectRepayService {
	
	/**
	 * 
	 * @param param:回报设置实体类数组
	 */
	void saveProjectRepay(Object[] param) throws SQLException ;

}
