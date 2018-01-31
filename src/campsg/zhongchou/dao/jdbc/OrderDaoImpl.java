package campsg.zhongchou.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import campsg.zhongchou.dao.OrderDao;
import campsg.zhongchou.entity.Order;
import campsg.zhongchou.entity.Project;
import campsg.zhongchou.entity.ProjectRepay;
import campsg.zhongchou.entity.ReceiveInfo;
import campsg.zhongchou.entity.User;
import campsg.zhongchou.utils.JDBCUtils;
import campsg.zhongchou.utils.Packager;

/** * @author  Hacker110 * @date 2016年12月28日 下午4:39:10 * @version 1.0  */
public class OrderDaoImpl extends JDBCBase implements OrderDao {
	
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	private ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();
	private ReceiveInfoDaoImpl receiveInfoDaoImpl = new ReceiveInfoDaoImpl();
	private ProjectRepayDaoImpl projectRepayDaoImpl  = new ProjectRepayDaoImpl();

	@Override
	public void saveOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO porder (project,user,projectrepay,count,order_date,receive_information,user_seller) VALUES(?,?,?,?,?,?,?)";
		
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		order.setOrder_date(sim.format(date.getTime()));
		
		Object[] param = {
				order.getProject_id(),
				order.getUser_id(),
				order.getProjectrepay_id(),
				order.getCount(),
				order.getOrder_date(),
				order.getReceive_information(),
				order.getUser_seller_id()
		};
		saveOrUpdateOrDelete(sql, param);
		
		
	}

	@Override
	public List<Order> getOrderByUser_id(int user_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = JDBCUtils.getConnection();
		String sql = "SELECT * FROM porder WHERE user="+user_id +"  order by order_date desc";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Order> orders = new ArrayList<>();
		Order order= null;
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				order = Packager.packOrder(rs);
				//获得下单用户
				User user = userDaoImpl.getUserById(order.getUser_id());
				order.setUser(user);
				//获得项目
				Project project = projectDaoImpl.getProjectById(order.getProject_id());
				order.setProject(project);
				//获得卖家
				User user_seller = userDaoImpl.getUserById(order.getUser_seller_id());
				order.setUser_seller(user_seller);
				//获得回报
				ProjectRepay projectRepay = projectRepayDaoImpl.getProjectRepayById(order.getProjectrepay_id());
				order.setProjectrepay(projectRepay);
				
				orders.add(order);
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(con);
		}

		return orders;
		
	}

	@Override
	public List<Order> getOrderByUser_seller(int user_seller_id) throws SQLException {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM porder WHERE user_seller="+user_seller_id;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = JDBCUtils.getConnection();
		List<Order> orders = new ArrayList<>();
		Order order = null;
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				
				order = Packager.packOrder(rs);
				
				
				//获得下单用户
				User user = userDaoImpl.getUserById(order.getUser_id());
				order.setUser(user);
				//获得卖家用户
				User user_seller = userDaoImpl.getUserById(order.getUser_seller_id());
				order.setUser_seller(user_seller);
				//获得项目
				Project project = projectDaoImpl.getProjectById(order.getProject_id());
				order.setProject(project);
				//获得收货地址
				ReceiveInfo receiveInfo = receiveInfoDaoImpl.getReceiveInfoById(order.getReceive_information());
				order.setReceiveInfo(receiveInfo);
				//获得回报
				ProjectRepay projectRepay = projectRepayDaoImpl.getProjectRepayById(order.getProjectrepay_id());
				order.setProjectrepay(projectRepay);
				orders.add(order);
			}
			
		}catch(SQLException e){
			throw e;
			
		}finally{
			JDBCUtils.releaseConnection(con);
		}
		return orders;
	}

	@Override
	public int updateOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE porder SET is_pay=?, payPrice=? where id="+order.getId();

		
		
		try{
			
			JDBCUtils.beginTransaction();
			
			ProjectDaoImpl pdi = new ProjectDaoImpl();
			ProjectRepayDaoImpl prdi = new ProjectRepayDaoImpl();
			
			Project p = pdi.getProjectById(order.getProject_id());
			p.setHas_fund_raising((prdi.getProjectRepayById(order.getProjectrepay_id()).getMoney())*order.getCount()+p.getHas_fund_raising());
			pdi.updateProject(p);
			
			Object[] param = {
					order.getIs_pay(),
					(prdi.getProjectRepayById(order.getProjectrepay_id()).getMoney())*order.getCount()
			};
			saveOrUpdateOrDelete(sql, param);
			JDBCUtils.commitTransaction();
			
		}catch(Exception e){
			JDBCUtils.rollbackTransaction();throw e;
		}
		
		
		
		return 1;
	}

	@Override
	public Order getOrderByid(int id) throws SQLException {
		// TODO Auto-generated method stub

		Connection con = JDBCUtils.getConnection();

		PreparedStatement ps =null;
		ResultSet rs = null;
		Order order = null;

		
		String sql = "SELECT * FROM porder u WHERE u.id = "+id;
		try{
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			//System.out.println("1");
			if(rs.next()){
				
				order = Packager.packOrder(rs);
				
			}
			} catch(SQLException e){
				e.printStackTrace();
			} finally{
				JDBCUtils.releaseConnection(con);
			}
		return order;
	}

}
