package com.yeah.zhongchou.dao;

import java.sql.SQLException;
import java.util.List;

import com.yeah.zhongchou.entity.Province;

public interface ProvinceDao {
	
	List<Province> querryProvinceList(int pid) throws SQLException;

}
