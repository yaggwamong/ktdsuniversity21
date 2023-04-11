package com.ktdsuniversity.admin.gnr.vo;

import com.ktdsuniversity.admin.common.vo.AbstractVO;

/**
 * GNR
 */
public class GnrVO extends AbstractVO{

	private int gnrId;
	private String gnrNm;
	private String crtDt;
	private String crtr;
	private String mdfyDt;
	private String mdfyr;
	private String useYn;
	private String delYn;


	public void setGnrId(int gnrId) {
		this.gnrId = gnrId;
	}

	public int getGnrId() {
		return this.gnrId;
	}

	public void setGnrNm(String gnrNm) {
		this.gnrNm = gnrNm;
	}

	public String getGnrNm() {
		return this.gnrNm;
	}

	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}

	public String getCrtDt() {
		return this.crtDt;
	}

	public void setCrtr(String crtr) {
		this.crtr = crtr;
	}

	public String getCrtr() {
		return this.crtr;
	}

	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}

	public String getMdfyDt() {
		return this.mdfyDt;
	}

	public void setMdfyr(String mdfyr) {
		this.mdfyr = mdfyr;
	}

	public String getMdfyr() {
		return this.mdfyr;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getUseYn() {
		return this.useYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getDelYn() {
		return this.delYn;
	}

}