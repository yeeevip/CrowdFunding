package campsg.zhongchou.dao;

import java.sql.SQLException;
import java.util.List;

import campsg.zhongchou.entity.ReceiveInfo;

/** * @author  Hacker110 * @date 2016年12月28日 下午6:30:56 * @version 1.0  */
public interface ReceiveInfoDao {
	/**
	 * 通过id
	 */
	ReceiveInfo getReceiveInfoById(int id) throws SQLException;
	
	/**
	 * 新建收货信息,返回id
	 */
	int saveReceiveInfo(ReceiveInfo receiveInfo) throws SQLException;
	
	ReceiveInfo getDefultReceiveInfo(int user_id,int is_default) throws SQLException;
	
	
	//设置默认收件地址
	int updateReceiveInfo(ReceiveInfo receiveInfo) throws SQLException;
	
	int deleteReceiveInfo(Integer id) throws SQLException;
	
	List<ReceiveInfo> queryReceiveInfos()  throws SQLException ;
	
}
