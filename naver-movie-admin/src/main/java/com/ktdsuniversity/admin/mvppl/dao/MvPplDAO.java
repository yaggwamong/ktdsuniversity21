package com.ktdsuniversity.admin.mvppl.dao;

import java.util.List;

import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

public interface MvPplDAO {

	
	public List<MvPplVO> readAllMvPplVO(MvPplVO mvPplVO);
	public List<MvPplVO> readAllMvPplVONoPagination(String MvPplNm);
	
	public MvPplVO readOneMvPplVOByMvPplId(String mvPplId);
	public int createMvPplVO(MvPplVO mvPplVO);
	public int updateOneMvPplByMvPplId(MvPplVO mvPplVO);
	public int deleteOneMvPplByMvPplId(int mvPplId);
	public int deleteMvPplBySelectedMvPplId(List<String> mvPplIdList);
	         
	
}
