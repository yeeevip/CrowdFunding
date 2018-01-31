package campsg.zhongchou.dao;

import java.sql.SQLException;
import java.util.List;

import campsg.zhongchou.entity.Province;

public interface ProvinceDao {
	
	List<Province> querryProvinceList(int pid) throws SQLException;

}
