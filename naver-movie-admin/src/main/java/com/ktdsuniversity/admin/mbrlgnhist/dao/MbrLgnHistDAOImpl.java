package com.ktdsuniversity.admin.mbrlgnhist.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.mbrlgnhist.vo.MbrLgnHistVO;

@Repository
public class MbrLgnHistDAOImpl extends SqlSessionDaoSupport implements MbrLgnHistDAO{

	@Override
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		// TODO Auto-generated method stub
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int createMbrHist(MbrLgnHistVO mbrLgnHistVO) {
		return getSqlSession().insert("MbrLgnHist.createMbrHist", mbrLgnHistVO);
	}
	
	
	

}
