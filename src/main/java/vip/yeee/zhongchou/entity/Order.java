package vip.yeee.zhongchou.entity;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class Order {
	private int id;
	private int user_id;
	private String author_name;
	private int project_id;
	private int projectrepay_id;
	private int count;
	private String order_date;
	private int is_pay;
	private int is_send;
	private int receive_information;
	private Project project;
	private User user;
	private ReceiveInfo receiveInfo;
	private int user_seller_id;
	private User user_seller;
	private ProjectRepay projectrepay;
	
	private Float payPrice;
	
	
	
	
	public Float getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(Float payPrice) {
		this.payPrice = payPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getProjectrepay_id() {
		return projectrepay_id;
	}
	public void setProjectrepay_id(int projectrrepay_id) {
		this.projectrepay_id = projectrrepay_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getIs_pay() {
		return is_pay;
	}
	public void setIs_pay(int is_pay) {
		this.is_pay = is_pay;
	}
	public int getIs_send() {
		return is_send;
	}
	public void setIs_send(int is_send) {
		this.is_send = is_send;
	}
	public int getReceive_information() {
		return receive_information;
	}
	public void setReceive_information(int receive_information) {
		this.receive_information = receive_information;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ReceiveInfo getReceiveInfo() {
		return receiveInfo;
	}
	public void setReceiveInfo(ReceiveInfo receiveInfo) {
		this.receiveInfo = receiveInfo;
	}
	public int getUser_seller_id() {
		return user_seller_id;
	}
	public void setUser_seller_id(int user_seller_id) {
		this.user_seller_id = user_seller_id;
	}
	public User getUser_seller() {
		return user_seller;
	}
	public void setUser_seller(User user_seller) {
		this.user_seller = user_seller;
	}
	public ProjectRepay getProjectrepay() {
		return projectrepay;
	}
	public void setProjectrepay(ProjectRepay projectrepay) {
		this.projectrepay = projectrepay;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", author_name="
				+ author_name + ", project_id=" + project_id
				+ ", projectrepay_id=" + projectrepay_id + ", count=" + count
				+ ", order_date=" + order_date + ", is_pay=" + is_pay
				+ ", is_send=" + is_send + ", receive_information="
				+ receive_information + ", project=" + project + ", user="
				+ user + ", receiveInfo=" + receiveInfo + ", user_seller_id="
				+ user_seller_id + ", user_seller=" + user_seller
				+ ", projectrepay=" + projectrepay + "]";
	}
	
	

}
