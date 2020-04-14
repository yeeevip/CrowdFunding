package com.yeah.zhongchou.entity;/** * @author  Hacker110 * @date 2016年12月28日 上午10:52:21 * @version 1.0  */
public class InitiatorPersonInfo {
	private int project_id;
	private String name;
	private String IDnumber;
	private String phone;
	private String szimg;
	private String sfimg;
	
	
	public String getSzimg() {
		return szimg;
	}
	public void setSzimg(String szimg) {
		this.szimg = szimg;
	}
	public String getSfimg() {
		return sfimg;
	}
	public void setSfimg(String sfimg) {
		this.sfimg = sfimg;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIDnumber() {
		return IDnumber;
	}
	public void setIDnumber(String iDnumber) {
		IDnumber = iDnumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "InitiatorPersonInfo [project_id=" + project_id + ", name=" + name + ", IDnumber=" + IDnumber
				+ ", phone=" + phone + "]";
	}
	
	
	

}
