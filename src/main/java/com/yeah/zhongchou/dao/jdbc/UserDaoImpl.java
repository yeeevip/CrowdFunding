package com.yeah.zhongchou.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yeah.zhongchou.dao.UserDao;
import com.yeah.zhongchou.entity.User;
import com.yeah.zhongchou.utils.JDBCUtils;
import com.yeah.zhongchou.utils.Packager;

public class UserDaoImpl extends JDBCBase implements UserDao {

	
	@Override
	public User getUserByCondition(String condition) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = JDBCUtils.getConnection();

		PreparedStatement ps =null;
		ResultSet rs = null;
		User user = null;
		
		
		
		
		
		String sql = "SELECT * FROM user u WHERE u.phone = ? or u.email = ?";
		try{
			ps = con.prepareStatement(sql);
			Object[] parm = {condition, condition};
			rs = query(ps,parm);
			//System.out.println("1");
			if(rs.next()){
				
				user = Packager.packUser(rs);
				
			}
			} catch(SQLException e){
				e.printStackTrace();
			} finally{
				JDBCUtils.releaseConnection(con);
			}
			
			return user;
			
		
	}



	@Override
	public List<User> getUsersByCondition(String condition, Integer page) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user";
		// TODO Auto-generated method stub
		if(condition !=null && !condition.equals(""))
			sql += " WHERE user_name LIKE '%" + condition +"%'";
		
		int max = 20; //单页最大显示数
		int start = (page - 1) * max;
		
		Connection con = JDBCUtils.getConnection();
		List<User> users = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		try{
			ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setMaxRows(start+max);
			rs = ps.executeQuery();
			rs.first();
			rs.relative(start - 1);
			
			while(rs.next()){
				user = Packager.packUser(rs);
				
				users.add(user);
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(con);
		}
		
		return users;
		
	}



	@Override
	public void save(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO user (phone,email,password,date_of_registration,user_name) VALUES(?,?,?,?,?)";
		String user_name = null;
		if(user.getPhone()!=null){
			user_name = user.getPhone();
		}else{
			user_name = user.getEmail();
		}
		Object[] param = {user.getPhone(),user.getEmail(),user.getPassword(),user.getDate_of_registration(),user_name};
		saveOrUpdateOrDelete(sql,param);
	}

	@Override
	public void update(User user) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("UPDATE user  SET user_name=?");
		ArrayList<Object> pList = new ArrayList<Object>();
		pList.add(user.getUser_name());
		
//
//		if(user.getUser_name()!=null){
//			sql.append(",user_name=?");
//			pList.add(user.getUser_name());
//		}
		if(user.getReal_name()!=null){
			sql.append(",real_name=?");
			pList.add(user.getReal_name());
		}
		if(user.getEmail()!=null){
			sql.append(",email=?");
			pList.add(user.getEmail());
		}
		if(user.getPhone()!=null){
			sql.append(",phone=?");
			pList.add(user.getPhone());
		}
		if(user.getId_number()!=null){
			sql.append(",id_number=?");
			pList.add(user.getId_number());
		}
		if(user.getSex()!=null){
			sql.append(",sex=?");
			pList.add(user.getSex());
		}
		sql.append("WHERE id="+user.getId());

		
		Object[] param = pList.toArray();
		saveOrUpdateOrDelete(sql.toString(), param);
		
	}

	@Override
	public User getUserById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user WHERE id="+id;
		Connection con = JDBCUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null ;
		User user = null;
		
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				user = Packager.packUser(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(con);
		}
		
		return user;
	}
	
	

}
