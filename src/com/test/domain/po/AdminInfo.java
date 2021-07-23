package com.test.domain.po;

import java.io.Serializable;
@SuppressWarnings("serial")
public class AdminInfo implements Serializable {
	
	private Integer adminId;
	private String adminname;
	private String adminpassword;
	public Integer getAdminId() {
		return adminId;
	}
	
	public AdminInfo() {
		super();
	}

	
	public AdminInfo(String adminname, String adminpassword) {
		super();
		this.adminname = adminname;
		this.adminpassword = adminpassword;
	}

	
	public AdminInfo(Integer adminId, String adminname, String adminpassword) {
		super();
		this.adminId = adminId;
		this.adminname = adminname;
		this.adminpassword = adminpassword;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	@Override
	public String toString() {
		return "AdminInfo [adminId=" + adminId + ", adminname=" + adminname + ", adminpassword=" + adminpassword + "]";
	}
	

}
