package campsg.zhongchou.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import campsg.zhongchou.dao.InitiatorInfoDao;
import campsg.zhongchou.entity.InitiatorCompanyInfo;
import campsg.zhongchou.entity.InitiatorPersonInfo;
import campsg.zhongchou.utils.JDBCUtils;
import campsg.zhongchou.utils.Packager;

/** * @author  Hacker110 * @date 2016年12月28日 上午11:11:27 * @version 1.0  */
public class InitiatorInfoDaoImpl extends JDBCBase implements InitiatorInfoDao {

	@Override
	public void saveInitiatorPersonInfo(InitiatorPersonInfo initiatorPersonInfo) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Initiator_personInfo (project,name,IDnumber,phone) VALUES(?,?,?,?)";
		Object[] param = {initiatorPersonInfo.getProject_id(),initiatorPersonInfo.getName(),initiatorPersonInfo.getIDnumber(),initiatorPersonInfo.getPhone()};
		saveOrUpdateOrDelete(sql, param);
		
	}

	@Override
	public void saveInitiatorCompanyInfo(InitiatorCompanyInfo initiatorCompanyInfo) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Initiator_companyInfo (project,firmName,businessNumber,slanderName,address,contactName,contactPhone) VALUES(?,?,?,?,?,?,?)";
		Object[] param = {initiatorCompanyInfo.getProject_id(),
							initiatorCompanyInfo.getFirmName(),
							initiatorCompanyInfo.getBusinessNumber(),
							initiatorCompanyInfo.getSlanderName(),
							initiatorCompanyInfo.getAddress(),
							initiatorCompanyInfo.getContactName(),
							initiatorCompanyInfo.getContactPhone()
						};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public InitiatorPersonInfo getInitiatorPersonInfoByProject_id(int project_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection  con = JDBCUtils.getConnection();
		String sql = "SELECT * FROM initiator_personinfo WHERE project="+project_id;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InitiatorPersonInfo initiatorP = null;
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				initiatorP = Packager.packInitiatorP(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(con);
		}
		return initiatorP;
	}

	@Override
	public InitiatorCompanyInfo getInitiatorCompanyInfoByProject_id(int project_id) throws SQLException {
		// TODO Auto-generated method stub

		Connection  con = JDBCUtils.getConnection();
		String sql = "SELECT * FROM initiator_companyinfo WHERE project ="+project_id;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InitiatorCompanyInfo initiatorC = null;
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				initiatorC = Packager.packInitiatorC(rs);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(con);
		}
		return initiatorC;
	}

}
