package com.test.domain.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EnterpriseInfo implements Serializable {
	private Integer eid;
	private String ename;
	private String eintro;
	private String intustry;

	public EnterpriseInfo() {
		super();
	}

	public EnterpriseInfo(String ename, String eintro, String intustry) {
		super();
		this.ename = ename;
		this.eintro = eintro;
		this.intustry = intustry;
	}

	public EnterpriseInfo(Integer eid, String ename, String eintro, String intustry) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eintro = eintro;
		this.intustry = intustry;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEintro() {
		return eintro;
	}

	public void setEintro(String eintro) {
		this.eintro = eintro;
	}

	public String getIntustry() {
		return intustry;
	}

	public void setIntustry(String intustry) {
		this.intustry = intustry;
	}

	@Override
	public String toString() {
		return "EnterpriseInfo [eid=" + eid + ", ename=" + ename + ", eintro=" + eintro + ", intustry=" + intustry
				+ "]";
	}

}
