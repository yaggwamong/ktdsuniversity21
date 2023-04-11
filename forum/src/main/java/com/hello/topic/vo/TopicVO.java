package com.hello.topic.vo;

import java.util.List;

import com.hello.common.vo.AbstractVO;
import com.hello.member.vo.MemberVO;
import com.hello.reply.vo.ReplyVO;

public class TopicVO extends AbstractVO {
	
	private int id;
	private String subject;
	private String content;
	private String email;
	private String crtDt;
	private String mdfyDt;
	
	/**
	 * 작성자 정보
	 */
	private MemberVO memberVO;
	
	/**
	 * 댓글 정보 (하나의 토픽은 여러 개의 댓글을 가진다 -> List)
	 */
	private List<ReplyVO> replyList;
	
	
	

	public List<ReplyVO> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<ReplyVO> replyList) {
		this.replyList = replyList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCrtDt() {
		return crtDt;
	}
	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}
	public String getMdfyDt() {
		return mdfyDt;
	}
	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	

}
