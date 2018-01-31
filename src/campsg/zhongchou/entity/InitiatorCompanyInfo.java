package campsg.zhongchou.entity;/** * @author  Hacker110 * @date 2016年12月28日 上午10:52:42 * @version 1.0  */
public class InitiatorCompanyInfo {
	private int project_id;
	private String firmName;
	private String businessNumber;
	private String slanderName;
	private String address;
	private String contactName;
	private String contactPhone;
	
	private String licenesPic;
	private String registeredNumPic;
	private String taxPig;
	
	
	
	public String getLicenesPic() {
		return licenesPic;
	}
	public void setLicenesPic(String licenesPic) {
		this.licenesPic = licenesPic;
	}
	public String getRegisteredNumPic() {
		return registeredNumPic;
	}
	public void setRegisteredNumPic(String registeredNumPic) {
		this.registeredNumPic = registeredNumPic;
	}
	public String getTaxPig() {
		return taxPig;
	}
	public void setTaxPig(String taxPig) {
		this.taxPig = taxPig;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	public String getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	public String getSlanderName() {
		return slanderName;
	}
	public void setSlanderName(String slanderName) {
		this.slanderName = slanderName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	@Override
	public String toString() {
		return "InitiatorCompanyInfo [project_id=" + project_id + ", firmName=" + firmName + ", businessNumber="
				+ businessNumber + ", slanderName=" + slanderName + ", address=" + address + ", contactName="
				+ contactName + ", contactPhone=" + contactPhone + "]";
	}
	
	
	

}
