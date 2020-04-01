package campsg.zhongchou.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCManager {
	
    private static String url = "jdbc:mysql://localhost:3306/crowdfunding" ;
    private static String username = "root" ;   
    private static String password = "123456789qq" ;   
	
	static {
		try {
			// 加载MySql的驱动类
		Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 创建数据库连接对象
	 */
	public static Connection getConnection() {
		Connection con = null;
		 
		 //Statement sql=null;
		 //ResultSet rs=null;
		try {
			
			con = DriverManager.getConnection(url, username, password);
			/***sql=con.createStatement();
			  rs=sql.executeQuery("select * from project where project_id="+1);
			  while(rs.next()){
			   System.out.println(rs.getInt("project_id"));
			   System.out.println(rs.getString("img_name"));
			  }**/
			
		} catch (Exception se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭数据库连接对象
	 */
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection con = JDBCManager.getConnection();
		System.out.println("获取数据库连接成功！");
		
		 
		
		
		close(null, null, con);
		System.out.println("成功关闭数据库连接！");
	}
}