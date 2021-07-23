package com.test.domain.po;

import java.util.Date;
import java.io.Serializable;
import 	java.math.BigDecimal;
@SuppressWarnings("serial")
public class Resume implements Serializable{
private Integer rid;
private String  rcompany;
private String  position;
private Date    workStartTime;
private Date    workEndTime;
private BigDecimal salary;
private String duty;
private String schoolName;
private String education;
private String professional;
private Date entranceTime;
private Date graduateTime;
private Integer examState;
private Integer userId;
public Resume() {
	super();
}
public Resume(Integer rid, String rcompany, String position, Date workStartTime, Date workEndTime, BigDecimal salary,
		String duty, String schoolName, String education, String professional, Date entranceTime, Date graduateTime,
		Integer examState, Integer userId) {
	super();
	this.rid = rid;
	this.rcompany = rcompany;
	this.position = position;
	this.workStartTime = workStartTime;
	this.workEndTime = workEndTime;
	this.salary = salary;
	this.duty = duty;
	this.schoolName = schoolName;
	this.education = education;
	this.professional = professional;
	this.entranceTime = entranceTime;
	this.graduateTime = graduateTime;
	this.examState = examState;
	this.userId = userId;
}
public Resume(String rcompany, String position, Date workStartTime, Date workEndTime, BigDecimal salary, String duty,
		String schoolName, String education, String professional, Date entranceTime, Date graduateTime,
		Integer examState, Integer userId) {
	super();
	this.rcompany = rcompany;
	this.position = position;
	this.workStartTime = workStartTime;
	this.workEndTime = workEndTime;
	this.salary = salary;
	this.duty = duty;
	this.schoolName = schoolName;
	this.education = education;
	this.professional = professional;
	this.entranceTime = entranceTime;
	this.graduateTime = graduateTime;
	this.examState = examState;
	this.userId = userId;
}
public Integer getRid() {
	return rid;
}
public void setRid(Integer rid) {
	this.rid = rid;
}
public String getRcompany() {
	return rcompany;
}
public void setRcompany(String rcompany) {
	this.rcompany = rcompany;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public Date getWorkStartTime() {
	return workStartTime;
}
public void setWorkStartTime(Date workStartTime) {
	this.workStartTime = workStartTime;
}
public Date getWorkEndTime() {
	return workEndTime;
}
public void setWorkEndTime(Date workEndTime) {
	this.workEndTime = workEndTime;
}
public BigDecimal getSalary() {
	return salary;
}
public void setSalary(BigDecimal salary) {
	this.salary = salary;
}
public String getDuty() {
	return duty;
}
public void setDuty(String duty) {
	this.duty = duty;
}
public String getSchoolName() {
	return schoolName;
}
public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
}
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
public String getProfessional() {
	return professional;
}
public void setProfessional(String professional) {
	this.professional = professional;
}
public Date getEntranceTime() {
	return entranceTime;
}
public void setEntranceTime(Date entranceTime) {
	this.entranceTime = entranceTime;
}
public Date getGraduateTime() {
	return graduateTime;
}
public void setGraduateTime(Date graduateTime) {
	this.graduateTime = graduateTime;
}
public Integer getExamState() {
	return examState;
}
public void setExamState(Integer examState) {
	this.examState = examState;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
@Override
public String toString() {
	return "Resume [rid=" + rid + ", rcompany=" + rcompany + ", position=" + position + ", workStartTime="
			+ workStartTime + ", workEndTime=" + workEndTime + ", salary=" + salary + ", duty=" + duty + ", schoolName="
			+ schoolName + ", education=" + education + ", professional=" + professional + ", entranceTime="
			+ entranceTime + ", graduateTime=" + graduateTime + ", examState=" + examState + ", userId=" + userId + "]";
}


}
