package com.yeah.zhongchou.dao;

import java.sql.SQLException;

import com.yeah.zhongchou.entity.InitiatorCompanyInfo;
import com.yeah.zhongchou.entity.InitiatorPersonInfo;

/** * @author https://www.yeee.vip  Hacker110 * @date 2016年12月28日 上午11:06:59 * @version 1.0  */
public interface InitiatorInfoDao {
	/**
	 * 保存个人发起项目身份信息
	 */
	void saveInitiatorPersonInfo(InitiatorPersonInfo initiatorPersonInfo) throws SQLException;
	/**
	 * 保存企业发起项目公司信息
	 */
	void saveInitiatorCompanyInfo(InitiatorCompanyInfo initiatorCompanyInfo) throws SQLException;
	
	InitiatorPersonInfo getInitiatorPersonInfoByProject_id(int project_id) throws SQLException;
	InitiatorCompanyInfo getInitiatorCompanyInfoByProject_id(int project_id) throws SQLException;

}
