package com.ktdsuniversity.admin.prdcprtcptnppl.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.mvgnr.dao.MvGnrDAO;
import com.ktdsuniversity.admin.prdcprtcptnppl.vo.PrdcPrtcptnPplVO;
@Repository
public class PrdcPrtcptnPplDAOImpl extends SqlSessionDaoSupport implements PrdcPrtcptnPplDAO{
	
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		// TODO Auto-generated method stub
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int createNewPrdcPrtcptnPpl(PrdcPrtcptnPplVO prdcPrtcptnPplVO) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("PrdcPrtcptnPpl.createNewPrdcPrtcptnPpl", prdcPrtcptnPplVO);
	}

	@Override
	public int deleteOnePrdcPrtcptnPplByPrdcPrtcptnPplId(String prdcPrtcptnPplId) {
		// TODO Auto-generated method stub
		return getSqlSession().update("PrdcPrtcptnPpl.deleteOnePrdcPrtcptnPplByPrdcPrtcptnPplId", prdcPrtcptnPplId);
	}

	@Override
	public int updateOnePrdcPrtcptnPpl(PrdcPrtcptnPplVO prdcPrtcptnPplVO) {
		// TODO Auto-generated method stub
		return getSqlSession().update("PrdcPrtcptnPpl.updateOnePrdcPrtcptnPpl", prdcPrtcptnPplVO);
	}

}
