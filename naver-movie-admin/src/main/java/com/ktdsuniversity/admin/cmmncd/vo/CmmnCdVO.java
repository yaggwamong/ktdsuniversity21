package com.ktdsuniversity.admin.cmmncd.vo;

/**
 * CMMN_CD
 */
public class CmmnCdVO {

	private String cdId;
	private String cdNm;
	private String prcdncCdId;
	private String crtDt;
	private String crtr;
	private String mdfyDt;
	private String mdfyr;
	private String useYn;
	private String delYn;


	public void setCdId(String cdId) {
		this.cdId = cdId;
	}

	public String getCdId() {
		return this.cdId;
	}

	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	public String getCdNm() {
		return this.cdNm;
	}

	public void setPrcdncCdId(String prcdncCdId) {
		this.prcdncCdId = prcdncCdId;
	}

	public String getPrcdncCdId() {
		return this.prcdncCdId;
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