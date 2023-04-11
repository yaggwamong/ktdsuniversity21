package com.ktdsuniversity.admin.mbrlgnhist.vo;

/**
 * MBR_LGN_HIST
 */
public class MbrLgnHistVO {

	private String histId;
	private String mbrId;
	private String act;
	private String actDt;
	private String ip;


	public void setHistId(String histId) {
		this.histId = histId;
	}

	public String getHistId() {
		return this.histId;
	}

	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	public String getMbrId() {
		return this.mbrId;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getAct() {
		return this.act;
	}

	public void setActDt(String actDt) {
		this.actDt = actDt;
	}

	public String getActDt() {
		return this.actDt;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}

}