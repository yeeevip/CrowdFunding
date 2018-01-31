package campsg.zhongchou.entity;

import java.util.Date;

/** * @author  作者 E-mail: * @date 创建时间：2016年12月14日 下午1:16:37 * @version 1.0 * @parameter  * @since  * @return  */
public class Comment {
	private int id;
	private int project;
	private User user;
	private int user_id;
	private String content;
	private Date time;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
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

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", project=" + project + ", user_id=" + user_id + ", content=" + content + ", time="
				+ time + "]";
	}

}
