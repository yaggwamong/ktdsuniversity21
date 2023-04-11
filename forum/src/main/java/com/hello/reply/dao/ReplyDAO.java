package com.hello.reply.dao;

import com.hello.reply.vo.ReplyVO;

public interface ReplyDAO {
	
	public int createNewReply(ReplyVO replyVO);
	
	public int updateOneReply(ReplyVO replyVO);
	
	public int deleteOneReplyById(int replyId);

}
