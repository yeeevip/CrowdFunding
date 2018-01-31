package campsg.zhongchou.dao;

import java.sql.SQLException;
import java.util.List;

import campsg.zhongchou.entity.ProjectProgress;

public interface ProjectProgressDao {
	
	void insertProjectProgress(ProjectProgress  projectProgress) throws SQLException;
	
	List<ProjectProgress> queryProjectProgress(Integer projectId) throws SQLException;

}
