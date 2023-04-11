package com.ktdsuniversity.admin.mvppl.vo;

import com.ktdsuniversity.admin.common.vo.AbstractVO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

/**
 * MV_PPL
 */
public class MvPplVO extends AbstractVO{

	private String mvPplId;
	private String nm;
	private String rlNm;
	private String prflPctr;
	private String crtDt;
	private String crtr;
	private String mdfyDt;
	private String mdfyr;
	private String useYn;
	private String delYn;

	
	private MbrVO crtrMbrVO;
	private MbrVO mdfyrMbrVO;
	               
	private String isDeletePctr;
	
	public String getIsDeletePctr() {
		return isDeletePctr;
	}

	public void setIsDeletePctr(String isDeletePctr) {
		this.isDeletePctr = isDeletePctr;
	}

	public MbrVO getCrtrMbrVO() {
		return crtrMbrVO;
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

	public void setMvPplId(String mvPplId) {
		this.mvPplId = mvPplId;
	}

	public String getMvPplId() {
		return this.mvPplId;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getNm() {
		return this.nm;
	}

	public void setRlNm(String rlNm) {
		this.rlNm = rlNm;
	}

	public String getRlNm() {
		return this.rlNm;
	}

	public void setPrflPctr(String prflPctr) {
		this.prflPctr = prflPctr;
	}

	public String getPrflPctr() {
		return this.prflPctr;
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