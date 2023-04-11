package com.ktdsuniversity.admin.gnr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktdsuniversity.admin.common.api.vo.ApiResponseVO;
import com.ktdsuniversity.admin.common.api.vo.ApiStatus;
import com.ktdsuniversity.admin.gnr.service.GnrService;
import com.ktdsuniversity.admin.gnr.vo.GnrVO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@RestController
public class RestGnrController {
	
	@Autowired
	private GnrService gnrService;
	
	@PostMapping("/api/gnr/create")
	private ApiResponseVO doCreateGnr(GnrVO GnrVO,
			@SessionAttribute("__ADMIN__") MbrVO mbrVO) {
		
		GnrVO.setCrtr(mbrVO.getMbrId());
		GnrVO.setMdfyr(mbrVO.getMbrId());
		
		
		boolean createResult =gnrService.createOneGnr(GnrVO);
		
		if(createResult) {
			return new ApiResponseVO(ApiStatus.OK);
			
		}
		else {
			return new ApiResponseVO(ApiStatus.FAIL);
		}
	}
	@PostMapping("/api/gnr/update")
	public ApiResponseVO doUpdateGnr(GnrVO gnrVO,
			@SessionAttribute("__ADMIN__") MbrVO mbrVO) {
		gnrVO.setMdfyr(mbrVO.getMbrId());
		
		boolean updateResult = gnrService.updateOneGnr(gnrVO);
		if(updateResult) {
			return new ApiResponseVO(ApiStatus.OK);
			
		}
		else {
			return new ApiResponseVO(ApiStatus.FAIL);
		}
	}
	@GetMapping("/api/gnr/delete/{gnrId}")
	public ApiResponseVO doDeleteGnr(@PathVariable int gnrId) {
		boolean deleteResult = gnrService.deleteOneGnrID(gnrId);
		
		if(deleteResult) {
			return new ApiResponseVO(ApiStatus.OK);
		}
		else {
			return new ApiResponseVO(ApiStatus.FAIL);
		}
		
	}
	@PostMapping("/api/gnr/delete")
	public ApiResponseVO doDeleteGnrBySelectedGnrId(@RequestParam List<Integer> gnrId) {
		boolean deleteResult = gnrService.deleteGnrBySelectedGnrId(gnrId);
		System.out.println(deleteResult);
		if(deleteResult){
			return new ApiResponseVO(ApiStatus.OK);
			
		}
		else {
			return new ApiResponseVO(ApiStatus.FAIL);
		}
	}

}
