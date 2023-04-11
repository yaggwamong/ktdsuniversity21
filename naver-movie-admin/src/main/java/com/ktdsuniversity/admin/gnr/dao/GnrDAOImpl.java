package com.ktdsuniversity.admin.gnr.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.gnr.vo.GnrVO;

@Repository
public class GnrDAOImpl extends SqlSessionDaoSupport implements GnrDAO{
	
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	@Override
	public List<GnrVO> readAllGnrVO(GnrVO gnrVO) {
		return getSqlSession().selectList("Gnr.readAllGnrVO", gnrVO);
	}
	@Override
	public List<GnrVO> readAllGnrVONoPagination(String gnrNm) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("Gnr.readAllGnrVONoPagination", gnrNm);
	}
	@Override
	public int createOneGnr(GnrVO gnrVO) {
		return getSqlSession().insert("Gnr.createOneGnr", gnrVO);
	}

	@Override
	public int updateOneGnr(GnrVO gnrVO) {
		return getSqlSession().update("Gnr.updateOneGnr", gnrVO);
	}

	@Override
	public int deleteOneGnrID(int gnrId) {
		return getSqlSession().update("Gnr.deleteOneGnrID", gnrId);
	}
	
	@Override
	public int deleteGnrBySelectedGnrId(List<Integer> gnrId) {
		return getSqlSession().update("Gnr.deleteGnrBySelectedGnrId", gnrId);
	}

}
