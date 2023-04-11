package com.hello.reply.service;

import com.hello.reply.vo.ReplyVO;

public interface ReplyService {
	
	public boolean createNewReply(ReplyVO replyVO);
	
	public boolean updateOneReply(ReplyVO replyVO);
	
	public boolean deleteOneReplyById(int replyId);

}
