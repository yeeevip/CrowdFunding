package com.yeah.zhongchou.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yeah.zhongchou.dao.ProvinceDao;
import com.yeah.zhongchou.entity.Province;
import com.yeah.zhongchou.utils.JDBCUtils;

public class ProvinceDaoImpl implements ProvinceDao {

	@Override
	public List<Province> querryProvinceList(int pid) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from province_city_district WHERE pid ="+ pid;
		List<Province>  provinceList = new ArrayList<>();
		
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()){
			Province p = new Province();
			p.setId(rs.getInt("id"));
			p.setPid(rs.getInt("pid"));
			p.setName(rs.getString("name"));
			provinceList.add(p);
		}
		JDBCUtils.releaseConnection(con);
		return provinceList;
	}

}
