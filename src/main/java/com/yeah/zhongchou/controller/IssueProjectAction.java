package com.yeah.zhongchou.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeah.zhongchou.constant.Constants;
import com.yeah.zhongchou.dao.jdbc.ProjectDaoImpl;
import com.yeah.zhongchou.entity.InitiatorCompanyInfo;
import com.yeah.zhongchou.entity.InitiatorPersonInfo;
import com.yeah.zhongchou.entity.Project;
import com.yeah.zhongchou.entity.ProjectRepay;
import com.yeah.zhongchou.entity.Projectdetail;
import com.yeah.zhongchou.entity.User;

/** * @author  Hacker110 * @date 2016年12月18日 下午4:34:43 * @version 1.0  */
public class IssueProjectAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("utf-8");
		try {
			gainProjectData(req, resp);
			
			resp.getWriter().print("{\"code\":\"0\",\"msg\":\"提交成功\"}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().print("{\"code\":\"-1\",\"msg\":\"提交失败#####"+e.toString()+"\"}");
			return;
		}
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	/**
	 * 从前端得到项目的信息并封装实体类
	
	 */
	private void gainProjectData(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException,SQLException,Exception{
		
		String idType = request.getParameter("idType");//发起性质
		

		/**
		 * //项目基本信息
		 */
		//从session中获取当前登录用户
		User user = (User) request.getSession().getAttribute(Constants.USER_KEY);
		int user_id = user.getId();

		int p_category =Integer.parseInt(request.getParameter("project_type")) ;
		String blurb = request.getParameter("blurb");
		String p_title = request.getParameter("p_title");
		String img_path = request.getParameter("cover_img");//项目封面路径
//		InputStream is = request.getPart("cover_img").getInputStream();
		int total_fund_raising =Integer.parseInt( request.getParameter("total_fund_raising"));
		int days_raising = Integer.parseInt(request.getParameter("days_raising"));
		

		//封装在Project实体类
		Integer is_audits = 0;
		Project project = new Project();
		project.setUser_id(user_id);
		project.setCategory_id(p_category);
		project.setTitle(p_title);
		project.setBlurb(blurb);
		project.setImg_name(img_path);
		project.setTotal_fund_raising(total_fund_raising);
		project.setDays_raising(days_raising);
		project.setShenfen(idType);
		project.setIs_audits(is_audits);
		//存进数据库
//		int project_id = projectDaoImpl.saveProject(project); //新建项目并获得新建的项目id
		
		/**
		 * //项目详情信息
		 */
		int number = Integer.parseInt(request.getParameter("detailCount"));
		String[] detail_title = new String[number];//多个详情标题
		String[] detail_content = new String[number];//多个详情内容
		Projectdetail[] projectdetail = new Projectdetail[number];
		List<Projectdetail> projectdetails = new ArrayList<>();

		for(int i=1;i<=number;i++){
			detail_title[i-1] = request.getParameter("detail_title"+i);
			detail_content[i-1] = request.getParameter("detail_content"+i);
			//封装在ProjectDetail实体类
			projectdetail[i-1] = new Projectdetail();
//			projectdetail[i-1].setProject_id(project_id);
			projectdetail[i-1].setTitle(detail_title[i-1]);
			projectdetail[i-1].setContent(detail_content[i-1]);
			projectdetails.add(projectdetail[i-1]);
		}
		//存进数据库
//		projectdetailDaoImpl.saveProjectdetail(projectdetails);

	/**
	 * 	//项目回报信息
	 */
		int pay_number = Integer.parseInt(request.getParameter("repayCount"));
		String[] repay_type = new String[pay_number];
		String[] repay_title = new String[pay_number];
		String[] repay_content = new String[pay_number];
		int[] repay_money = new int[pay_number];
		int[] repay_time = new int[pay_number];
		ProjectRepay[] projectRepay = new ProjectRepay[pay_number];
		List<ProjectRepay> projectRepays = new ArrayList<>();
		
		for(int j=1;j<=pay_number;j++){
			repay_type[j-1] = request.getParameter("repay_type"+j);
			repay_title[j-1] = request.getParameter("repay_title"+j);
			repay_content[j-1] = request.getParameter("repay_content"+j);
			repay_money[j-1] = Integer.parseInt(request.getParameter("repay_money"+j));
			repay_time[j-1] = Integer.parseInt(request.getParameter("repay_time"+j));
			//封装在ProjectRepay实体类中
			projectRepay[j-1] = new ProjectRepay();
//			projectRepay[j-1].setProject(project_id);
			projectRepay[j-1].setTitle(repay_title[j-1]);
			projectRepay[j-1].setContent(repay_content[j-1]);
			projectRepay[j-1].setType(repay_type[j-1]);
			projectRepay[j-1].setMoney(repay_money[j-1]);
			projectRepay[j-1].setTime(repay_time[j-1]);
			projectRepays.add(projectRepay[j-1]);
		}
		
		//存进数据库
//		projectRepayDaoImpl.saveProjectRepay(projectRepays);
		
		
		
		

		/**
		 * 身份信息
		 */
		
		if(idType.equals("个人")){
			
			String name = request.getParameter("name");
			String IDnumber = request.getParameter("IDnumber");
			String phone = request.getParameter("phone");
			String szimg = request.getParameter("szimg");
			String sfimg = request.getParameter("sfimg");
			
			//封装在InitiatorPersonInfo实体类中
			InitiatorPersonInfo initiatorPersonInfo = new InitiatorPersonInfo();
//			initiatorPersonInfo.setProject_id(project_id);
			initiatorPersonInfo.setName(name);
			initiatorPersonInfo.setIDnumber(IDnumber);
			initiatorPersonInfo.setPhone(phone);
			initiatorPersonInfo.setSzimg(szimg);
			initiatorPersonInfo.setSfimg(sfimg);
			//存进数据库
//			initiatorInfoDaoImpl.saveInitiatorPersonInfo(initiatorPersonInfo);
			projectDaoImpl.saveProject(project, projectdetails, projectRepays, initiatorPersonInfo);
			
			
		}
		if(idType.equals("企业")){
			String firmName = request.getParameter("firmName");
			String businessNumber = request.getParameter("businessNumber");
			String address = request.getParameter("address");
			String contactName = request.getParameter("contactName");
			String contactPhone = request.getParameter("contactPhone");
			String slanderName = request.getParameter("slanderName");
		/*	
			String slanderName = request.getParameter("slanderName");
			String slanderName = request.getParameter("slanderName");
			String slanderName = request.getParameter("slanderName");*/
			
			//封装在InitiatorCompanyInfo实体类中
			InitiatorCompanyInfo initiatorCompanyInfo = new InitiatorCompanyInfo();
//			initiatorCompanyInfo.setProject_id(project_id);
			initiatorCompanyInfo.setFirmName(firmName);
			initiatorCompanyInfo.setBusinessNumber(businessNumber);
			initiatorCompanyInfo.setAddress(address);
			initiatorCompanyInfo.setContactName(contactName);
			initiatorCompanyInfo.setContactPhone(contactPhone);
			initiatorCompanyInfo.setSlanderName(slanderName);
			//存进数据库
//			initiatorInfoDaoImpl.saveInitiatorCompanyInfo(initiatorCompanyInfo);
			projectDaoImpl.saveProject(project, projectdetails, projectRepays, initiatorCompanyInfo);
		}
		
		


	}

}
