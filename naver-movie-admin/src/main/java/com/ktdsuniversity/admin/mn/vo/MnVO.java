package com.ktdsuniversity.admin.mn.vo;

/**
 * MN
 */
public class MnVO {

	private int mnId;
	private String mnNm;
	private int prtnMnId;
	private String url;
	private String crtDt;
	private String crtr;
	private String mdfyDt;
	private String mdfyr;
	private String useYn;
	private String delYn;


	public void setMnId(int mnId) {
		this.mnId = mnId;
	}

	public int getMnId() {
		return this.mnId;
	}

	public void setMnNm(String mnNm) {
		this.mnNm = mnNm;
	}

	public String getMnNm() {
		return this.mnNm;
	}

	public void setPrtnMnId(int prtnMnId) {
		this.prtnMnId = prtnMnId;
	}

	public int getPrtnMnId() {
		return this.prtnMnId;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
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