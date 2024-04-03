package com.yeah.zhongchou.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.yeah.zhongchou.dao.ProjectcategoryDao;
import com.yeah.zhongchou.entity.Projectcategory;
import com.yeah.zhongchou.utils.JDBCUtils;
import com.yeah.zhongchou.utils.Packager;

/** * @author https://www.yeee.vip  作者 E-mail: * @date 创建时间：2016年12月15日 下午6:11:27 * @version 1.0 * @parameter  * @since  * @return  */
public class ProjectcategoryDaoImpl implements ProjectcategoryDao {

	@Override
	public Projectcategory getcategoryById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		String sql = "SELECT * FROM projectcategory WHERE id =" + id ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Projectcategory projectcategory = null;
		
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				projectcategory = Packager.packProjectcategory(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtils.releaseConnection(con);
		}
		
		return projectcategory;
	}

}
