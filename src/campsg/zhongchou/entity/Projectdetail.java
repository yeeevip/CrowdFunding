package campsg.zhongchou.entity;

import java.io.Serializable;

public class Projectdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int project_id;
	private Project project;
	private String title;
	private String content;
	
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public Project getProject(){
		return project;
	}
	public void setProject(Project project){
		this.project = project;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content = content;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + id;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projectdetail other = (Projectdetail) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	public Projectdetail(int id, Project project, String title, String content) {
		super();
		this.id = id;
		this.project = project;
		this.title = title;
		this.content = content;
	}
	
	public Projectdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Projectdetail [id=" + id + ", project=" + project + ", title=" + title + ", content=" + content + "]";
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	
}
