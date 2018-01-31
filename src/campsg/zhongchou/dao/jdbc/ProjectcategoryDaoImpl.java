package campsg.zhongchou.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import campsg.zhongchou.dao.ProjectcategoryDao;
import campsg.zhongchou.entity.Projectcategory;
import campsg.zhongchou.utils.JDBCUtils;
import campsg.zhongchou.utils.Packager;

/** * @author  作者 E-mail: * @date 创建时间：2016年12月15日 下午6:11:27 * @version 1.0 * @parameter  * @since  * @return  */
public class ProjectcategoryDaoImpl implements ProjectcategoryDao {

	@Override
	public Projectcategory getcategoryById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		String sql = "SELECT * FROM Projectcategory WHERE id =" + id ;
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
