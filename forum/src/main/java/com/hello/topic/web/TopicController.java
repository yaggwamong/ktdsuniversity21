package com.hello.topic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.hello.common.handler.DownloadUtil;
import com.hello.member.vo.MemberVO;
import com.hello.topic.service.TopicService;
import com.hello.topic.vo.TopicVO;

@Controller
public class TopicController {
	
	private static final Logger logger = LoggerFactory.getLogger(TopicController.class);
	
	@Autowired
	private TopicService topicService;
	
	
	@Value("${upload.path}")
	private String uploadPath;
	
	
	// jsp에 데이터를 보낼 때에는 model.addAttribute를 사용한다
	@GetMapping("/topics")
	public String viewTopicListPage(Model model) {
		List<TopicVO> topicList = topicService.readAllTopics();
		model.addAttribute("topicList", topicList); 
		return "topic/list";
	}
	
	@GetMapping("/topic/{topicId}")
	public String viewTopicDetailPage(@PathVariable int topicId, Model model) {
		logger.info("URL 변수 topicId의 값 : {}", topicId);
		
		TopicVO topic = topicService.readOneTopicByTopicId(topicId);
		model.addAttribute("topic", topic);
		return "topic/detail";
	}
	
	@GetMapping("/topic/write")
	public String viewTopicWritePage() {
		return "topic/write";
	}
	
	// redirect -> 브라우저에게 302를 요청해서 페이지를 바꾼다
	// uploadFile을 VO 안에 넣어버려도 되긴 하는데... 그러면 DB에 메모리가 계속 쌓이니 그냥 파라미터로 주는 것이 더 낫다
	@PostMapping("/topic/write")
	public String doTopicWrite(TopicVO topicVO,
			                   List<MultipartFile> uploadFile,
			                   @SessionAttribute("__USER_SESSION_DATA__") MemberVO memberVO) {
		
		// 로그인 한 세션의 정보를 넣어 준다
		topicVO.setEmail(memberVO.getEmail());
		
		boolean createResult = topicService.createNewTopic(topicVO, uploadFile);
		// create가 된 이후에야 topicVO가 가진 topicId를 알 수 있기에 아래로 이동시켰음
//		uploadHandler.upload(uploadFile, topicVO.getId());
		if(!createResult) {
			return "topic/write";
		}
		return "redirect:/topic/" + topicVO.getId();
	}
	
	@GetMapping("/topic/delete/{topicId}")
	public String doTopicDelete(@PathVariable int topicId) {
		boolean deleteResult = topicService.deleteOneTopic(topicId);
		if (deleteResult) {
			return "redirect:/topics";
		}
		else {
			return "redirect:/topic/" + topicId;
		}
	}
	
	@GetMapping("/topic/update/{topicId}")
	public String viewTopicUpdatePage(@PathVariable int topicId, Model model) {
		TopicVO topic = topicService.readOneTopicByTopicId(topicId);
		model.addAttribute("topic", topic);
		return "topic/update";
	}
	
	@PostMapping("/topic/update/{topicId}")
	public String doTopicUpdate(@PathVariable int topicId,TopicVO topicVO,
			                    @SessionAttribute("__USER_SESSION_DATA__") MemberVO memberVO) {
		
		topicVO.setEmail(memberVO.getEmail());
		topicVO.setId(topicId);
		boolean updateResult = topicService.updateOneTopic(topicVO);
		
		if(updateResult) {
			return "redirect:/topic/" + topicId;
		}
		
		return "redirect:/topics";
	}
	
	// request 와 response 는 DispatcherServlet 이 보내 준다.
	@GetMapping("/topic/download/{topicId}")
	public void downloadFile(@PathVariable int topicId
			        , HttpServletRequest request
			        , HttpServletResponse response) {
		TopicVO topic = topicService.readOneTopicByTopicId(topicId);
		
		new DownloadUtil(response, request, this.uploadPath + "/" 
		                 + topic.getFileName()).download(topic.getOriginFileName());
	}
	
	
	
	

}
