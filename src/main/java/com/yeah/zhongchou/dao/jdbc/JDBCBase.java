package com.yeah.zhongchou.dao.jdbc;/** * @author  作者 E-mail: * @date 创建时间：2016年12月12日 下午3:04:30 * @version 1.0 * @parameter  * @since  * @return  */

import java.sql.*;

import com.yeah.zhongchou.utils.JDBCUtils;


public class JDBCBase {
/**
		 * 封装未知参数并查询结果集
		 * @param ps 由sql语句实例化的PreparedStatement对象
		 * @param param 存放未知参数的数组
		 * @return 结果集
		 */
		protected ResultSet query(PreparedStatement ps, Object[] param){
			
			return query(ps,param,null,null);
		}
		/**
		 * 封装未知参数并查询分页结果集
		 * @param ps 由sql语句实例化的PreparedStatement对象
		 * @param param 存放未知参数的数组
		 * @param start 起始索引
		 * @param maxCount 当页最大值
		 * @return 结果集
		 */
		protected ResultSet query(PreparedStatement ps , Object[] param , Integer start , Integer maxCount) {
			
			ResultSet rs = null;
			try{
				if(param != null){
					for(int i = 0;i<param.length;i++){
						ps.setObject(i+1, param[i]);
					}
				}
					//设置查询到记录的最大索引
					if(start != null && maxCount !=null)
						ps.setMaxRows(start+maxCount);
					rs = ps.executeQuery();
					
					//设置查询到记录的起始索引
					if(start != null && maxCount != null){
						rs.first();
						rs.relative(start - 1);
						
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			return rs;
		}

		/**
		 * 非事务添加/更新操作
		 * @param sql sql语句
		 * @param param 存放未知参数的数组
		 * @return 添加操作的记录的id值
		 * @throws SQLException 
		 */
		@SuppressWarnings("null")
		protected int save(String sql,Object[] param) throws SQLException{
			Connection con = JDBCUtils.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			int id = -1;
			try{
				if(param != null){
					for(int i=0;i<param.length;i++){
						ps.setObject(i+1, param[i]);
					}
				}
				ps.executeUpdate();
				rs = ps.getGeneratedKeys();
				if(rs.next()){
					//获取插入数据的id
					rs.getInt(1);
				}
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}finally{
				JDBCUtils.releaseConnection(con);
			}
			return id;
		}
		
		
		
		/**
		 * 事务添加/更新操作
		 * @param sql sql语句
		 * @param param 存放未知参数的数组
		 * @param con 数据库连接对象
		 * @return 添加操作的记录的id值
		 * @throws SQLException 
		 */
		protected int save(String sql, Object[] param, Connection con) throws SQLException{
			PreparedStatement ps = null;
			ResultSet rs = null;
			int id = -1;
			try{
				/**
				 * RETURN_GENERATED_KEYS：设置PreparedStatement为可返回键值的模式
				 * 一般用于获取自动生成的键值
				 */
				ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				if(param != null){
					for(int i=0;i<param.length;i++){
						ps.setObject(i+1, param[i]);
					
				}
			}
					ps.executeUpdate();
					rs = ps.getGeneratedKeys();
					if(rs.next()){
						//获取插入数据的id值
						id = rs.getInt(1);
					}
				
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
//				try{
//					//事务发生异常时回滚
//					con.rollback();
//				}catch(SQLException e1){
//					e1.printStackTrace();
//				}
			}/*finally{
					JDBCManager.close(rs, ps, null);
				}*/
			return id;
		}
		
		
		/**
		 * 可以用来处理增、删、改的方法
		 * @throws SQLException 
		 */
		protected void saveOrUpdateOrDelete(String sql,Object values[]) throws SQLException{
			PreparedStatement stmt =null;
			Connection conn = JDBCUtils.getConnection();
			try {
				stmt = conn.prepareStatement(sql);
				if(values != null){
					for(int i=0;i<values.length;i++){
						stmt.setObject(i+1, values[i]);
					}
				}
				stmt.execute();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
				
	/*			try{
					//事务发生异常时回滚
					conn.rollback();
				}catch(SQLException e1){
					e1.printStackTrace();
				}*/
				
			}/*finally{
				JDBCManager.close(null, stmt, conn);
			}*/
		}

}
