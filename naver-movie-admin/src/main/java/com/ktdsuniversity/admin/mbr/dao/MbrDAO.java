package com.ktdsuniversity.admin.mbr.dao;

import java.util.List;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;

public interface MbrDAO {

	
	public int readCountMbrById(String mbrId);	//중복검사
	public String readSaltMbrById(String mbrId);  //salt 정보가져오기 
	public String readLgnBlockYnById(String mbrId);

	public MbrVO readOneMbrByIdAndPwd(MbrVO mbrVO);
	
	public int updateMbrLgnSucc(MbrVO mbrVO); //성공 관련
	public int updateMbrLgnFail(MbrVO mbrVO); //실패 횟수증가
	public int updateMbrLgnBlock(MbrVO mbrVO); // 차단여부
	
	public List<MbrVO> readAllAdminMbr();
	
	public int createNewAdminMbr(MbrVO mbrVO);
	public int updateOneNewAdminMbr(MbrVO mbrVO);
	public int deleteOneNewAdminMbr(String mbrId);
	
}
