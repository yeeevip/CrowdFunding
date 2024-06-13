package vip.yeee.zhongchou.entity;import java.io.Serializable;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ProjectRepay implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int project;
	private String title;
	private String content;
	private String type;
	private int money;
	private int time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ProjectRepay [id=" + id + ", project=" + project + ", title=" + title + ", content=" + content
				+ ", type=" + type + ", money=" + money + ", time=" + time + "]";
	}
	
	

}
