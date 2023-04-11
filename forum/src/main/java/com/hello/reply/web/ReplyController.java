package com.hello.reply.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hello.member.vo.MemberVO;
import com.hello.reply.service.ReplyService;
import com.hello.reply.vo.ReplyVO;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/topic/reply/create")
	public String doCreateReply(ReplyVO replyVO, @SessionAttribute("__USER_SESSION_DATA__") MemberVO memberVO) {
		
		replyVO.setEmail(memberVO.getEmail());
		boolean createResult = replyService.createNewReply(replyVO);
		if(createResult) {
			return "redirect:/topic/" + replyVO.getTopicId();
		}
		return "redirect:/topic/" + replyVO.getTopicId() + "?errorCode=fail";
	}
	
	@PostMapping("/topic/reply/update/{replyId}")
	public String doUpdateReply(@PathVariable int replyId, ReplyVO replyVO) {
		replyVO.setReplyId(replyId);
		boolean updateResult = replyService.updateOneReply(replyVO);
		if(updateResult) {
			return "redirect:/topic/" + replyVO.getReplyId();
		}
		return "redirect:/topic/" + replyVO.getReplyId() + "?errorCode=updateFail";
	}
	
	//@PathVariable 여러번 쓸 때는 순서를 맞춰서 적어주면 된다
	@GetMapping("/topic/reply/delete/{topicId}/{replyId}")
	public String doDeleteReply(@PathVariable int topicId, @PathVariable int replyId) {
		boolean deleteResult = replyService.deleteOneReplyById(replyId);
		if(deleteResult) {
			return "redirect:/topic/" + topicId;
		}
		return "redirect:/topic/" + topicId + "?errorCode=deleteFail";
	}

}
