package com.yeah.zhongchou.dao.jdbc;

import java.sql.SQLException;
import java.util.List;

import com.yeah.zhongchou.dao.ProjectdetailDao;
import com.yeah.zhongchou.entity.Projectdetail;

/** * @author  Hacker110 * @date 2016年12月18日 下午5:46:41 * @version 1.0  */
public class ProjectdetailDaoImpl extends JDBCBase implements ProjectdetailDao {

	@Override
	public void saveProjectdetail(List<Projectdetail> projectdetails) throws SQLException {
		// TODO Auto-generated method stub
		for(int i=0;i<projectdetails.size();i++){
			
			String sql = "INSERT INTO Project_detail (project_id,dtitle,dcontent) VALUES(?,?,?)";
			Object[] param = {projectdetails.get(i).getProject_id(),projectdetails.get(i).getTitle(),projectdetails.get(i).getContent()};
			
			saveOrUpdateOrDelete(sql, param);
			
			
		}

	}

}
