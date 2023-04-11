package com.ktdsuniversity.admin.mvppl.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

public interface MvPplService {
	public List<MvPplVO> readAllMvPplVO(MvPplVO mvPplVO);
	public List<MvPplVO> readAllMvPplVONoPagination(String mvPplNm);
	
	
	public boolean createMvPplVO(MvPplVO mvPplVO,MultipartFile uploadFile);
	public boolean updateOneMvPplByMvPplId(MvPplVO mvPplVO,MultipartFile uploadFile);
	public boolean deleteOneMvPplByMvPplId(int mvPplId);
	public boolean deleteMvPplBySelectedMvPplId(List<String> mvPplIdList);

}
