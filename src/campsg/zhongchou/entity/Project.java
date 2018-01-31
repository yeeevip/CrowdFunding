package campsg.zhongchou.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
			
	private Integer project_id;
	private String title;
	private String blurb;
	private String img_name;
	private Integer total_fund_raising;
	private Integer has_fund_raising;
	private Integer days_raising;
	private Integer is_index;
	private int category_id;
	private Integer is_audits;
	private List<Projectdetail> projectdetail;
	private int user_id;
	private Projectcategory projectcategory;
	private String launch_date;
	private List<ProjectRepay> projectRepay;
	private InitiatorPersonInfo initiatorPersonInfo;
	private InitiatorCompanyInfo initiatorCompanyInfo;
	private String shenfen;
	private int is_finish;
	
	//private String leftDays;
	
	


	

	public int getIs_finish() {
		return is_finish;
	}
	public void setIs_finish(int is_finish) {
		this.is_finish = is_finish;
	}
	public Projectcategory getProjectcategory() {
		return projectcategory;
	}
	public void setProjectcategory(Projectcategory projectcategory) {
		this.projectcategory = projectcategory;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int catagory_id) {
		this.category_id = catagory_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Integer getIs_audits() {
		return is_audits;
	}
	public void setIs_audits(Integer is_audits) {
		this.is_audits = is_audits;
	}
	public Integer getProject_id() {
		return project_id;
	}
	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBlurb() {
		return blurb;
	}
	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public Integer getTotal_fund_raising() {
		return total_fund_raising;
	}
	public void setTotal_fund_raising(Integer total_fund_raising) {
		this.total_fund_raising = total_fund_raising;
	}
	public Integer getHas_fund_raising() {
		return has_fund_raising;
	}
	public void setHas_fund_raising(Integer has_fund_raising) {
		this.has_fund_raising = has_fund_raising;
	}
	public Integer getDays_raising() {
		return days_raising;
	}
	public void setDays_raising(Integer days_raising) {
		this.days_raising = days_raising;
	}
	public Integer getIs_index(){
		return is_index;
	}
	public void setIs_index(Integer is_index){
		this.is_index=is_index;
	}

	public List<Projectdetail> getProjectdetail(){
		return projectdetail;
	}
	public void setProjectdetail(List<Projectdetail> projectdetail){
		this.projectdetail = projectdetail;
	}
	
	
	public String getLaunch_date() {
		return launch_date;
	}
	public void setLaunch_date(String launch_date) {
		this.launch_date = launch_date;
	}
	public List<ProjectRepay> getProjectRepay() {
		return projectRepay;
	}
	public void setProjectRepay(List<ProjectRepay> projectRepay) {
		this.projectRepay = projectRepay;
	}
	public InitiatorPersonInfo getInitiatorPersonInfo() {
		return initiatorPersonInfo;
	}
	public void setInitiatorPersonInfo(InitiatorPersonInfo initiatorPersonInfo) {
		this.initiatorPersonInfo = initiatorPersonInfo;
	}
	public InitiatorCompanyInfo getInitiatorCompanyInfo() {
		return initiatorCompanyInfo;
	}
	public void setInitiatorCompanyInfo(InitiatorCompanyInfo initiatorCompanyInfo) {
		this.initiatorCompanyInfo = initiatorCompanyInfo;
	}
	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", title=" + title + ", blurb=" + blurb + ", img_name=" + img_name
				+ ", total_fund_raising=" + total_fund_raising + ", has_fund_raising=" + has_fund_raising
				+ ", days_raising=" + days_raising + ", is_index=" + is_index + ", category_id=" + category_id
				+ ", is_audits=" + is_audits + ", projectdetail=" + projectdetail + ", user_id=" + user_id
				+ ", projectcategory=" + projectcategory + ", launch_date=" + launch_date + ", projectRepay="
				+ projectRepay + ", initiatorPersonInfo=" + initiatorPersonInfo + ", initiatorCompanyInfo="
				+ initiatorCompanyInfo + "]";
	}
	public String getShenfen() {
		return shenfen;
	}
	public void setShenfen(String shenfen) {
		this.shenfen = shenfen;
	}
	
	
	public String getLeftDays(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date current = new Date();
		Date date = null;
		try {
			date = df.parse(launch_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long days_rai =  ((long)days_raising*24*60*60*1000);
		Long times = current.getTime() - date.getTime();//已经筹集天数
		Long lefttimes = days_rai-times;
		
		if(lefttimes<=0){
			return "0天";
		}
		
		if(lefttimes>0&&lefttimes<60*1000){
			return new Double(Math.floor(lefttimes/(1000))).intValue()+"秒";
		}else if(lefttimes>=60*1000&&lefttimes<60*60*1000){
			return new Double(Math.floor(lefttimes/(60*1000))).intValue()+"分钟";
		}else if(lefttimes>=60*60*1000&&lefttimes<24*60*60*1000){
			return new Double(Math.floor(lefttimes/(60*60*1000))).intValue()+"小时";
		}
			return new Double(Math.floor(lefttimes/(24*60*60*1000))).intValue()+"天";
		
		
	}




	
	
	
	
	
	
	
	
	
}