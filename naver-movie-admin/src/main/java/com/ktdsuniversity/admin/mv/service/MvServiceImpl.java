package com.ktdsuniversity.admin.mv.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.admin.common.api.exceptions.ApiArgsException;
import com.ktdsuniversity.admin.common.api.exceptions.ApiException;
import com.ktdsuniversity.admin.mv.dao.MvDAO;
import com.ktdsuniversity.admin.mv.vo.MvVO;
import com.ktdsuniversity.admin.mvgnr.dao.MvGnrDAO;
import com.ktdsuniversity.admin.mvgnr.vo.MvGnrVO;
import com.ktdsuniversity.admin.prdcprtcptnppl.dao.PrdcPrtcptnPplDAO;
import com.ktdsuniversity.admin.prdcprtcptnppl.vo.PrdcPrtcptnPplVO;

@Service
public class MvServiceImpl implements MvService{
	
	@Value("${upload.mv.poster.path:/naver-movie-admin/files/mv/poster}")
	private String pstrPath;
	@Autowired
	private MvDAO mvDAO;
	@Autowired
	private PrdcPrtcptnPplDAO prdcPrtcptnPplDAO;
	@Autowired
	private MvGnrDAO mvGnrDAO;
	
	@Override
	public boolean createNewMv(MvVO mvVO, MultipartFile uploadFile) {
		if(uploadFile!= null && !uploadFile.isEmpty()) {
			// 파일 저장.
			// 포스터를 저장할 폴더 있는지 체크 
			File dir = new File(pstrPath);
			if(!dir.exists()) {
				//없다면 폴더 생성
				dir.mkdirs();
			}
				
			// 난수이름의 파일을 임시생성
			String uuidFimeName = UUID.randomUUID().toString();
			File pstrFile = new File(dir,uuidFimeName);
			// 임시 생성한 파일에 업로드 파일 이동 
			try {
				uploadFile.transferTo(pstrFile);
			}catch (IllegalStateException | IOException e) {
				throw new ApiException("500", "포스터 업로드를 실패했습니다. ");
			}
			mvVO.setPstr(uuidFimeName);		
		}
		
		int mvCreateCount = mvDAO.createNewMv(mvVO);
		
		if(mvCreateCount > 0 ) {
			// 장르 등록 - 반복
			List<MvGnrVO> gnrList  = mvVO.getGnrList();
			if(gnrList == null || gnrList.isEmpty()) {
				throw new ApiArgsException("404", "장르를 선택하세요");
			}
			for(MvGnrVO gnr: gnrList) {
				gnr.setMvId(mvVO.getMvId());
				gnr.setCrtr(mvVO.getCrtr());
				gnr.setMdfyr(mvVO.getMdfyr());
				mvGnrDAO.createNewMvGnr(gnr);
			}
			// 영화참여인 등록 - 반복
			List<PrdcPrtcptnPplVO> pplList  = mvVO.getMvPplList();
			if(pplList == null || pplList.isEmpty()) {
				
				throw new ApiArgsException("404", "영화참여인을 선택하세요");
			}
			for(PrdcPrtcptnPplVO ppl: pplList) {
				ppl.setMvId(mvVO.getMvId());
				ppl.setCrtr(mvVO.getCrtr());
				ppl.setMdfyr(mvVO.getMdfyr());
				prdcPrtcptnPplDAO.createNewPrdcPrtcptnPpl(ppl);			
			}
		}
		return mvCreateCount > 0;
	}

	@Override
	public boolean updateOneMv(MvVO mvVO,MultipartFile uploadFile) {
		if(uploadFile!= null && !uploadFile.isEmpty()) {
			// 파일 저장.
			// 포스터를 저장할 폴더 있는지 체크 
			File dir = new File(pstrPath);
			if(!dir.exists()) {
				//없다면 폴더 생성
				dir.mkdirs();
			}
				
			// 난수이름의 파일을 임시생성
			String uuidFimeName = UUID.randomUUID().toString();
			File pstrFile = new File(dir,uuidFimeName);
			// 임시 생성한 파일에 업로드 파일 이동 
			try {
				uploadFile.transferTo(pstrFile);
			}catch (IllegalStateException | IOException e) {
				throw new ApiException("500", "포스터 업로드를 실패했습니다. ");
			}
			mvVO.setPstr(uuidFimeName);		
		}
		
		int mvUpdateCount = mvDAO.updateOneMv(mvVO);
		
		if(mvUpdateCount > 0 ) {
			// 장르 등록 - 반복
			List<MvGnrVO> gnrList  = mvVO.getGnrList();
			if(gnrList == null || gnrList.isEmpty()) {
				throw new ApiArgsException("404", "장르를 선택하세요");
			}
			for(MvGnrVO gnr: gnrList) {
				
				if(gnr.getAdded()!= null && gnr.getAdded().equals("true")) {
				   gnr.setMvId(mvVO.getMvId());
				   gnr.setCrtr(mvVO.getCrtr());
				   gnr.setMdfyr(mvVO.getMdfyr());
				   mvGnrDAO.createNewMvGnr(gnr);	
				}
				else if(gnr.getDeleted() !=null && gnr.getDeleted().length() > 0){
					gnr.setMvId(mvVO.getMvId());
					gnr.setGnrId(Integer.parseInt(gnr.getDeleted()));
					mvGnrDAO.deleteOneMvGnrByGnrIdAndMvId(gnr);
					
				}
				
			}
			// 영화참여인 등록 - 반복
			List<PrdcPrtcptnPplVO> pplList  = mvVO.getMvPplList();
			if(pplList == null || pplList.isEmpty()) {
				
				throw new ApiArgsException("404", "영화참여인을 선택하세요");
			}
			for(PrdcPrtcptnPplVO ppl: pplList) {
				if(ppl.getAdded()!=null && ppl.getAdded().equals("true")) {
					ppl.setMvId(mvVO.getMvId());
					ppl.setCrtr(mvVO.getCrtr());
					ppl.setMdfyr(mvVO.getMdfyr());
					prdcPrtcptnPplDAO.createNewPrdcPrtcptnPpl(ppl);		
				}
				else if(ppl.getModified()!= null && ppl.getModified().length() >0) {
					ppl.setPrdcPrtcptnId(ppl.getModified());
					prdcPrtcptnPplDAO.updateOnePrdcPrtcptnPpl(ppl);
					
				}
				else if(ppl.getDeleted()!=null && ppl.getDeleted().length() >0){
					prdcPrtcptnPplDAO.deleteOnePrdcPrtcptnPplByPrdcPrtcptnPplId(ppl.getDeleted());	
				}					
			}
		}
		return mvUpdateCount > 0;
	
	}

	@Override
	public boolean deleteOneMvByMvId(String mvId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMvByMvIdList(List<String> MvIdList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MvVO readOneMvByMvId(String mvId) {
		// TODO Auto-generated method stub
		return mvDAO.readOneMvByMvId(mvId);
	}

	@Override
	public List<MvVO> readAllMv(MvVO mvVO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
