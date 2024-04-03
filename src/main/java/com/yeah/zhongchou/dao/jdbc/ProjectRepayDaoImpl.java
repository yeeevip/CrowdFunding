package com.yeah.zhongchou.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yeah.zhongchou.dao.ProjectRepayDao;
import com.yeah.zhongchou.entity.ProjectRepay;
import com.yeah.zhongchou.utils.JDBCUtils;
import com.yeah.zhongchou.utils.Packager;

/** * @author https://www.yeee.vip  Hacker110 * @date 2016年12月18日 下午4:16:46 * @version 1.0  */
public class ProjectRepayDaoImpl extends JDBCBase implements ProjectRepayDao {

	@Override
	public void saveProjectRepay(List<ProjectRepay> projectRepays) throws SQLException {
		// TODO Auto-generated method stub
		for(int i=0;i<projectRepays.size();i++){
			String sql = "INSERT INTO projectRepay (project_id,paytitle,paycontent,type,time,money) VALUES(?,?,?,?,?,?) ";
			Object[] param = {projectRepays.get(i).getProject(),
					projectRepays.get(i).getTitle(),
					projectRepays.get(i).getContent(),
					projectRepays.get(i).getType(),
					projectRepays.get(i).getTime(),
					projectRepays.get(i).getMoney()};
			
			saveOrUpdateOrDelete(sql, param);
		}
		

		
	}

	@Override
	public ProjectRepay getProjectRepayById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		String sql = "SELECT * FROM projectrepay WHERE id="+id;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProjectRepay projectRepay = null;
		
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				
				projectRepay = Packager.packProjectRepay(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(con);
		}
		return projectRepay;
	}

	@Override
	public List<ProjectRepay> getProjectRepayByProjectId(int project_id)
			throws SQLException {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		String sql =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProjectRepay> projectRepayList = new ArrayList<>();
		try{
			sql = "SELECT * FROM projectrepay WHERE project_id="+project_id;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				ProjectRepay p = new ProjectRepay();
				p = Packager.packProjectRepay(rs);
				projectRepayList.add(p);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(con);
		}
		
		return projectRepayList;
	}

	
}
