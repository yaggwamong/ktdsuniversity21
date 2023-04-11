package com.ktdsuniversity.admin.mvppl.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

@Repository
public class MvPPlDAOImpl extends SqlSessionDaoSupport implements MvPplDAO{
	
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		// TODO Auto-generated method stub
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public List<MvPplVO> readAllMvPplVO(MvPplVO mvPplVO) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("MvPpl.readAllMvPplVO", mvPplVO);
	}
	
	@Override
	public List<MvPplVO> readAllMvPplVONoPagination(String MvPplNm) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("MvPpl.readAllMvPplVONoPagination", MvPplNm);
	}
	@Override
	public MvPplVO readOneMvPplVOByMvPplId(String mvPplId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("MvPpl.readOneMvPplVOByMvPplId", mvPplId);
	}
	
	@Override
	public int createMvPplVO(MvPplVO mvPplVO) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("MvPpl.createMvPplVO", mvPplVO);
	}

	@Override
	public int updateOneMvPplByMvPplId(MvPplVO mvPplVO) {
		// TODO Auto-generated method stub
		return getSqlSession().update("MvPpl.updateOneMvPplByMvPplId", mvPplVO);
	}

	@Override
	public int deleteOneMvPplByMvPplId(int mvPplId) {
		// TODO Auto-generated method stub
		return getSqlSession().update("MvPpl.deleteOneMvPplByMvPplId", mvPplId);
	}

	@Override
	public int deleteMvPplBySelectedMvPplId(List<String> mvPplIdList) {
		// TODO Auto-generated method stub
		return getSqlSession().update("MvPpl.deleteMvPplBySelectedMvPplId", mvPplIdList);
	}
	
	
	
	
	
	
	
	

}
