package vip.yeee.zhongchou.entity;

import java.text.ParseException;

import vip.yeee.zhongchou.utils.DateUtil;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ProjectProgress {
	
	private Integer id;
	private Integer projectId;
	private String content;
	private String publishDate;
	private String pubUser;
	
	public String getPubUser() {
		return pubUser;
	}
	public void setPubUser(String pubUser) {
		this.pubUser = pubUser;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		
		try {
			publishDate = DateUtil.timeToNow(publishDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.publishDate = publishDate;
	}

	
	
	

}
