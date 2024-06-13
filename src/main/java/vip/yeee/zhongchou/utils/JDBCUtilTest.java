package vip.yeee.zhongchou.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class JDBCUtilTest {
	/**
	 * 底层使用了c3p0连接池，说明我们还要提供c3p0配置文件
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetConnection() throws SQLException {

		Connection con = JDBCUtils.getConnection();
		System.out.println(con);
		JDBCUtils.releaseConnection(con);
		System.out.println(con.isClosed());
	}
}
