package campsg.zhongchou.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import campsg.zhongchou.dao.ProvinceDao;
import campsg.zhongchou.entity.Province;
import campsg.zhongchou.utils.JDBCUtils;

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
