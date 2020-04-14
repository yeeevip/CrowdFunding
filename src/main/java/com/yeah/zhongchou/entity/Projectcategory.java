package com.yeah.zhongchou.entity;

import java.sql.Date;

/** * @author  作者 E-mail: * @date 创建时间：2016年12月15日 下午5:59:30 * @version 1.0 * @parameter  * @since  * @return  */
public class Projectcategory {
	private int id;
	private String category_name;
	private String note;
	private Date create_date;
	private String change_person;
	private int peoject_amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String catagory_name) {
		this.category_name = catagory_name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getChange_person() {
		return change_person;
	}
	public void setChange_person(String change_person) {
		this.change_person = change_person;
	}
	public int getPeoject_amount() {
		return peoject_amount;
	}
	public void setPeoject_amount(int peoject_amount) {
		this.peoject_amount = peoject_amount;
	}
	@Override
	public String toString() {
		return "Projectcatagory [id=" + id + ", catagory_name=" + category_name + ", note=" + note + ", create_date="
				+ create_date + ", change_person=" + change_person + ", peoject_amount=" + peoject_amount + "]";
	}
	
	
	
}
