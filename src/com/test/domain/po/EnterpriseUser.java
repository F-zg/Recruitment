package com.test.domain.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EnterpriseUser implements Serializable{
   private Integer euid;
   private String euname;
   private String eupassword;
   private Integer eid;
public EnterpriseUser() {
	super();
}
public EnterpriseUser(Integer euid, String euname, String eupassword, Integer eid) {
	super();
	this.euid = euid;
	this.euname = euname;
	this.eupassword = eupassword;
	this.eid = eid;
}
public EnterpriseUser(String euname, String eupassword, Integer eid) {
	super();
	this.euname = euname;
	this.eupassword = eupassword;
	this.eid = eid;
}
public Integer getEuid() {
	return euid;
}
public void setEuid(Integer euid) {
	this.euid = euid;
}
public String getEuname() {
	return euname;
}
public void setEuname(String euname) {
	this.euname = euname;
}
public String getEupassword() {
	return eupassword;
}
public void setEupassword(String eupassword) {
	this.eupassword = eupassword;
}
public Integer getEid() {
	return eid;
}
public void setEid(Integer eid) {
	this.eid = eid;
}

   
}
