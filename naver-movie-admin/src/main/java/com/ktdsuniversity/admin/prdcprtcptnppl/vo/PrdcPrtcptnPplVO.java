package com.ktdsuniversity.admin.prdcprtcptnppl.vo;

import java.util.List;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;
import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

/**
 * PRDC_PRTCPTN_PPL
 */
public class PrdcPrtcptnPplVO {

	private String prdcPrtcptnId;
	private String mvId;
	private String mvPplId;
	private String mssn;
	private String rspnsbltRolNm;
	private String crtDt;
	private String crtr;
	private String mdfyDt;
	private String mdfyr;
	private String useYn;
	private String delYn;
	
	private String added;
	private String deleted;
	private String modified;
	

	
	private MvPplVO mvPplVO; 
	private MbrVO crtrMbrVO;	
	private MbrVO mdfyrMbrVO;




	public MbrVO getCrtrMbrVO() {
		return crtrMbrVO;
	}

	public String getAdded() {
		return added;
	}

	public void setAdded(String added) {
		this.added = added;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public void setCrtrMbrVO(MbrVO crtrMbrVO) {
		this.crtrMbrVO = crtrMbrVO;
	}

	public MbrVO getMdfyrMbrVO() {
		return mdfyrMbrVO;
	}

	public void setMdfyrMbrVO(MbrVO mdfyrMbrVO) {
		this.mdfyrMbrVO = mdfyrMbrVO;
	}

	public MvPplVO getMvPplVO() {
		return mvPplVO;
	}

	public void setMvPplVO(MvPplVO mvPplVO) {
		this.mvPplVO = mvPplVO;
	}

	public void setPrdcPrtcptnId(String prdcPrtcptnId) {
		this.prdcPrtcptnId = prdcPrtcptnId;
	}

	public String getPrdcPrtcptnId() {
		return this.prdcPrtcptnId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvPplId(String mvPplId) {
		this.mvPplId = mvPplId;
	}

	public String getMvPplId() {
		return this.mvPplId;
	}

	public void setMssn(String mssn) {
		this.mssn = mssn;
	}

	public String getMssn() {
		return this.mssn;
	}

	public void setRspnsbltRolNm(String rspnsbltRolNm) {
		this.rspnsbltRolNm = rspnsbltRolNm;
	}

	public String getRspnsbltRolNm() {
		return this.rspnsbltRolNm;
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