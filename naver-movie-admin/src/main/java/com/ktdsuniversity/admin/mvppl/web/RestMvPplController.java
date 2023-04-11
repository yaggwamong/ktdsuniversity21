package com.ktdsuniversity.admin.mvppl.web;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.admin.common.api.vo.ApiResponseVO;
import com.ktdsuniversity.admin.common.api.vo.ApiStatus;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;
import com.ktdsuniversity.admin.mvppl.service.MvPplService;
import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;


@RestController
public class RestMvPplController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(RestMvPplController.class);
	
	@Autowired
	private MvPplService mvPplService;
	

	
	@PostMapping("/api/mvppl/create")
	public ApiResponseVO doCreateMvPpl(MvPplVO mvPplVO,MultipartFile uploadFile,
										@SessionAttribute("__ADMIN__") MbrVO mbrVO) {
		mvPplVO.setCrtr(mbrVO.getMbrId());
		mvPplVO.setMdfyr(mbrVO.getMbrId());
		
		//TODO 필수 파라미터 체크
		
		
		boolean isSuccess = mvPplService.createMvPplVO(mvPplVO,uploadFile);
		if(isSuccess) {
			return new ApiResponseVO(ApiStatus.OK);
		}
		else {
			return new ApiResponseVO(ApiStatus.FAIL);
		}
	}
	@PostMapping("/api/mvppl/update")
	public ApiResponseVO doUpdateMvPpl(MvPplVO mvPplVO,MultipartFile uploadFile,
										@SessionAttribute("__ADMIN__") MbrVO mbrVO) {
		mvPplVO.setCrtr(mbrVO.getMbrId());
		mvPplVO.setMdfyr(mbrVO.getMbrId());
		

		boolean isSuccess = mvPplService.updateOneMvPplByMvPplId(mvPplVO,uploadFile);
		if(isSuccess) {
			return new ApiResponseVO(ApiStatus.OK);
		}
		else {
			return new ApiResponseVO(ApiStatus.FAIL);
		}
	}


}
