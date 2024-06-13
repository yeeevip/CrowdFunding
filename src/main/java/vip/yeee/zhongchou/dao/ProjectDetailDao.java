package vip.yeee.zhongchou.dao;

import java.sql.SQLException;
import java.util.List;

import vip.yeee.zhongchou.entity.ProjectDetail;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ProjectDetailDao extends BaseDao {

	public void saveProjectDetail(List<ProjectDetail> projectDetails) throws SQLException {
		for(int i=0;i<projectDetails.size();i++){
			
			String sql = "INSERT INTO project_detail (project_id,dtitle,dcontent) VALUES(?,?,?)";
			Object[] param = {projectDetails.get(i).getProject_id(),projectDetails.get(i).getTitle(),projectDetails.get(i).getContent()};
			
			saveOrUpdateOrDelete(sql, param);
			
		}

	}

}
