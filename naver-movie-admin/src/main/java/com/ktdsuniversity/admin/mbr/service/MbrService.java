package com.ktdsuniversity.admin.mbr.service;

import java.util.List;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;
import com.ktdsuniversity.admin.mbrlgnhist.vo.MbrLgnHistVO;

public interface MbrService {
	
	public int readCountMbrById(String mbrId);
	
	public MbrVO readOneMbrByIdAndPwd(MbrVO mbrVO);
		
	public List<MbrVO> readAllAdminMbr();
	
	public boolean createNewAdminMbr(MbrVO mbrVO);
	public boolean updateOneNewAdminMbr(MbrVO mbrVO);
	public boolean deleteOneNewAdminMbr(String mbrId);
	
	public boolean createLogoutHist(MbrLgnHistVO mbrLgnHistVO);
	
}
