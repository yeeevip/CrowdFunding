package com.yeah.zhongchou.dao;



import java.sql.SQLException;
import java.util.List;

import com.yeah.zhongchou.entity.Project;
import com.yeah.zhongchou.entity.ProjectRepay;
import com.yeah.zhongchou.entity.Projectdetail;

public interface ProjectDao {
	//根据是否显示在首页 和 类型 查找
	List<Project> getProjectByIs_index(int is,int type) throws SQLException;
	//通过id
	Project getProjectById(int id) throws SQLException;
	
	/**
	 * 
	 * @param key
	 * @return
	 */

	Integer getProjectNum(String projectType , String key) throws SQLException;
	/**
	 * 通过是否审核
	 * @param key
	 * @param page
	 * @return
	 */
	List<Project> getProjectByIs_audits(int is_audits) throws SQLException;
	
	//附加条件搜索
	/*
	 * key:关键字
	 * page:当前页码
	 */
	List<Project> getProjectByCondition(Project project, Integer page,Integer showCount) throws SQLException;
	
	/**
	 * 获取全部项目，进行分页显示
	 */
	List<Project> getProjectByPage(Integer page) throws SQLException;
	
	/**
	 * 通过用户id查找用户发起的项目
	 */
	Integer getProjectByUser_id(int user_id) throws SQLException;
	
	/**
	 * 创建项目
	 * @author  	: Hacker110
	 * @data		: 2017年7月2日 下午5:33:22
	 * @Description : 
	 * @param project	基本信息
	 * @param projectdetails  详情信息 多表
	 * @param projectRepay  回报信息  多表
	 * @param identity   身份信息
	 * @return	
	 *
	 */
	void saveProject(Project project,List<Projectdetail> projectdetails,List<ProjectRepay> projectRepay,Object identity) throws SQLException;
	/**
	 * 通过审核
	 * 
	 */
	void passAudits(int project_id,int is_audits) throws SQLException;
	
	
	int updateProject(Project p) throws SQLException;
	
}
