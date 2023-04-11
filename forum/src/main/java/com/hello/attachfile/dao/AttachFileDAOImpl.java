package com.hello.attachfile.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.attachfile.vo.AttachFileVO;

@Repository
public class AttachFileDAOImpl extends SqlSessionDaoSupport implements AttachFileDAO {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int createAttachFile(AttachFileVO attachFileVO) {
		return getSqlSession().insert("Attach.createAttachFile", attachFileVO);
	}

	@Override
	public AttachFileVO readOneAttachFileByTopicIdAndFileId(AttachFileVO attachFileVO) {
		return getSqlSession().selectOne("Attach.readOneAttachFileByTopicIdAndFileId", attachFileVO);
	}
	
	// ServiceImpl delete~에서 넘어옴
	@Override
	public String readOneAttachFileByUUIDByFileId(long fileID) {
		return getSqlSession().selectOne("Attach.readOneAttachFileByUUIDByFileId", fileID);
	}

	@Override
	public int deleteOneAttachFileByFileId(long fileId) {
		return getSqlSession().delete("Attach.deleteOneAttachFileByFileId", fileId);
	}

}
