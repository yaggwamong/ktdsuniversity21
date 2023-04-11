package com.hello.reply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.reply.dao.ReplyDAO;
import com.hello.reply.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;

	@Override
	public boolean createNewReply(ReplyVO replyVO) {
		return replyDAO.createNewReply(replyVO) > 0;
	}

	@Override
	public boolean updateOneReply(ReplyVO replyVO) {
		return replyDAO.updateOneReply(replyVO) > 0;
	}

	@Override
	public boolean deleteOneReplyById(int replyId) {
		return replyDAO.deleteOneReplyById(replyId) > 0;
	}

}
