package com.yeah.zhongchou.entity;

public class Province {
	Integer id ;
	Integer pid;//父id
	String name ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", pid=" + pid + ", name=" + name + "]";
	}
	

}
