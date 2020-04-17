package com.yeah.zhongchou.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yeah.zhongchou.dao.ProjectProgressDao;
import com.yeah.zhongchou.entity.ProjectProgress;
import com.yeah.zhongchou.utils.JDBCUtils;

public class ProjectProgressDaoImpl extends JDBCBase implements ProjectProgressDao {

	@Override
	public void insertProjectProgress(ProjectProgress projectProgress) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		String sql = "INSERT INTO project_progress "
				+ "(project_id,content,publish_date,pubUser)"
				+ " VALUES(?,?,?,?)";
		Object[] param = {projectProgress.getProjectId(),projectProgress.getContent(),new Date(),projectProgress.getPubUser()};
		
		try{
			JDBCUtils.beginTransaction();
			save(sql, param, con);
			JDBCUtils.commitTransaction();
		}catch(Exception e){
			e.printStackTrace();
			JDBCUtils.rollbackTransaction();
			
		}
		
	}

	@Override
	public List<ProjectProgress> queryProjectProgress(Integer projectId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProjectProgress> projectProgressList = new ArrayList<>();
		String sql = "select * from project_progress where project_id="+projectId+" order by publish_date desc";
		
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				ProjectProgress projectProgress = new ProjectProgress();
				projectProgress.setId(rs.getInt("id"));
				projectProgress.setProjectId(rs.getInt("project_id"));
				projectProgress.setContent(rs.getString("content"));
				projectProgress.setPublishDate(rs.getString("publish_date"));
				projectProgress.setPubUser(rs.getString("pubUser"));
				
				projectProgressList.add(projectProgress);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		 
		
		return projectProgressList;
	}

}
