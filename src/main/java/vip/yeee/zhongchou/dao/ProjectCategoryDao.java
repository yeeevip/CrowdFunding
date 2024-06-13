package vip.yeee.zhongchou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vip.yeee.zhongchou.entity.ProjectCategory;
import vip.yeee.zhongchou.utils.JDBCUtils;
import vip.yeee.zhongchou.utils.Packager;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ProjectCategoryDao {

	public ProjectCategory getCategoryById(int id) throws SQLException {
		Connection con = JDBCUtils.getConnection();
		String sql = "SELECT * FROM projectcategory WHERE id =" + id ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProjectCategory projectcategory = null;
		
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
