package com.test.vo;

public class IsMater {
	
	
	String no;// iS_MATER;//	NO	Varchar2	4	-	-	1	-	-	-
	String korName; //KOR_NAME;//	Varchar2	20	-	-	-	널 가능	-	-
	String juminNo;//JUMIN_NO;//	Varchar2	14	-	-	-	널 가능	-	-
	String engName;//ENG_NAME;//	Varchar2	20	-	-	-	널 가능	-	-
	String sex;//SEX;//	Varchar2	1	-	-	-	널 가능	-	-
	String lastSchool;//LAST_SCHOOL;//	Varchar2	15	-	-	-	널 가능	-	-
	String major;//MAJOR;//	Varchar2	15	-	-	-	널 가능	-	-
	String graduDate;//GRADU_DATE;//	Varchar2	10	-	-	-	널 가능	-	-
	String comLag;//COM_LAG;//	Varchar2	4	-	-	-	널 가능	-	-
	String licence1;//LICENCE1;//	Varchar2	20	-	-	-	널 가능	-	-
	String licence2;//	Varchar2	20	-	-	-	널 가능	-	-
	String licence3;//	Varchar2	20	-	-	-	널 가능	-	-
	String techLev;//TECH_LEV;//	Varchar2	10	-	-	-	널 가능	-	-
	String address;//ADDRESS;//	Varchar2	20	-	-	-	널 가능	-	-
	String workDate;//WORK_DATE;//	Varchar2	10	-	-	-	널 가능	-	-
	String state;//STATE;//	Varchar2	1	-	-	-	널 가능	-	-
	String image;//IMAGE;//	Varchar2	50	-	-	-	널 가능	-	-
	String workFlag;//WORK_FLAG;//	Varchar2	1	-	-	-	널 가능	-	-
	String phone;//PHONE;//	Varchar2	15	-	-	-	널 가능	-	-
	String email;//EMAIL;//	Varchar2	50	-
	
	
	public IsMater() {
		super();
	}
	
	
	

	//등록시
	public IsMater(String korName, String juminNo, String engName, String sex, String lastSchool,
			String major, String graduDate, String comLag, String licence1, String licence2, String licence3,
			String techLev, String address, String workDate, String state, String image, String workFlag, String phone,
			String email) {
		super();
		this.korName = korName;
		this.juminNo = juminNo;
		this.engName = engName;
		this.sex = sex;
		this.lastSchool = lastSchool;
		this.major = major;
		this.graduDate = graduDate;
		this.comLag = comLag;
		this.licence1 = licence1;
		this.licence2 = licence2;
		this.licence3 = licence3;
		this.techLev = techLev;
		this.address = address;
		this.workDate = workDate;
		this.state = state;
		this.image = image;
		this.workFlag = workFlag;
		this.phone = phone;
		this.email = email;
	}





	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getKorName() {
		return korName;
	}


	public void setKorName(String korName) {
		this.korName = korName;
	}


	public String getJuminNo() {
		return juminNo;
	}


	public void setJuminNo(String juminNo) {
		this.juminNo = juminNo;
	}


	public String getEngName() {
		return engName;
	}


	public void setEngName(String engName) {
		this.engName = engName;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getLastSchool() {
		return lastSchool;
	}


	public void setLastSchool(String lastSchool) {
		this.lastSchool = lastSchool;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getGraduDate() {
		return graduDate;
	}


	public void setGraduDate(String graduDate) {
		this.graduDate = graduDate;
	}


	public String getComLag() {
		return comLag;
	}


	public void setComLag(String comLag) {
		this.comLag = comLag;
	}


	public String getLicence1() {
		return licence1;
	}


	public void setLicence1(String licence1) {
		this.licence1 = licence1;
	}


	public String getLicence2() {
		return licence2;
	}


	public void setLicence2(String licence2) {
		this.licence2 = licence2;
	}


	public String getLicence3() {
		return licence3;
	}


	public void setLicence3(String licence3) {
		this.licence3 = licence3;
	}


	public String getTechLev() {
		return techLev;
	}


	public void setTechLev(String techLev) {
		this.techLev = techLev;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getWorkDate() {
		return workDate;
	}


	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getWorkFlag() {
		return workFlag;
	}


	public void setWorkFlag(String workFlag) {
		this.workFlag = workFlag;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "IsMater [no=" + no + ", korName=" + korName + ", juminNo=" + juminNo + ", engName=" + engName + ", sex="
				+ sex + ", lastSchool=" + lastSchool + ", major=" + major + ", graduDate=" + graduDate + ", comLag="
				+ comLag + ", licence1=" + licence1 + ", licence2=" + licence2 + ", licence3=" + licence3 + ", techLev="
				+ techLev + ", address=" + address + ", workDate=" + workDate + ", state=" + state + ", image=" + image
				+ ", workFlag=" + workFlag + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
	
	
	

}
