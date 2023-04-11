package com.ktdsuniversity.admin.mv.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.admin.mv.vo.MvVO;

public interface MvService {
	
	public boolean createNewMv(MvVO mvVO, MultipartFile uploadFile);
	
	public boolean updateOneMv(MvVO mvVO,MultipartFile uploadFile);
	public boolean deleteOneMvByMvId(String mvId);
	public boolean deleteMvByMvIdList(List<String> MvIdList);
	public MvVO readOneMvByMvId(String mvId);
	public List<MvVO> readAllMv(MvVO mvVO);

}
