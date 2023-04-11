package com.hello.member.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.common.exceptions.AjaxResponseException;
import com.hello.common.util.StringUtil;
import com.hello.member.service.MemberService;
import com.hello.member.vo.MemberVO;

@Controller
public class RestMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestMemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/api/member/login")
	@ResponseBody // 응답을 json 형태로 전송한다 -> Ajax 형태에서는 model은 쓰지 않아 정리했음
	public Map<String, Object> doLogin(MemberVO memberVO, HttpSession session) {
		if (memberVO.getEmail() == null || memberVO.getEmail().length() == 0) {
			throw new RuntimeException("email은 필수 값 입니다.");
		}
		if (memberVO.getPassword() == null || memberVO.getPassword().length() == 0) {
			throw new RuntimeException("비밀번호는 필수 값 입니다.");
		}
		
		// 회원 데이터 조회
		MemberVO memberData = memberService.readOneMembeByEmailAndPassword(memberVO);
		
		// 회원 데이터가 있는지 확인
		if (memberData != null) {
			// 로그인 성공
			// 세션 생성 후 데이터 저장
			session.setAttribute("__USER_SESSION_DATA__", memberData);
			Map<String, Object> result = new HashMap<>();
			result.put("loginResult", true);
			return result;
		}
		else {
			// 로그인 실패
			// 실패했다는 정보 전송
			Map<String, Object> result = new HashMap<>();
			result.put("loginResult", false);
			result.put("errorcode", "NOT_FOUND_USER");
			return result;
		}
	}
	
	@GetMapping("/api/member/check/{email}/")
	@ResponseBody
	public Map<String, Object> doCheckDuplicatedEmail(@PathVariable String email) {
		int emailCount = memberService.readCountMemberByEmail(email);
		Map<String, Object> result = new HashMap<>();
		result.put("email_count", emailCount);
		return result;
	}
	
	
	
	
	@PostMapping("/api/member/regist")
	@ResponseBody // 응답을 json 형태로 전송한다
	public Map<String, Object> doMemeberRegist(MemberVO memberVO) {
		
		String email = memberVO.getEmail();
		String name = memberVO.getName();
		String password = memberVO.getPassword();
		String passwordConfirm = memberVO.getPasswordConfirm();
		
		if (StringUtil.isEmpty(email)) {
			throw new AjaxResponseException("email은 필수 값 입니다.");
		}
		if (StringUtil.isEmpty(name)) {
			throw new AjaxResponseException("name은 필수 값 입니다.");
		}
		if (StringUtil.isEmpty(password)) {
			throw new AjaxResponseException("password은 필수 값 입니다.");
		}
		if (StringUtil.isEmpty(passwordConfirm)) {
			throw new AjaxResponseException("passwordConfirm은 필수 값 입니다.");
		}
		if (StringUtil.isExceedLength(email, 100)) {
			throw new AjaxResponseException("email은 100글자까지 작성할 수 있습니다.");
		}
		if (StringUtil.isExceedLength(name, 10)) {
			throw new AjaxResponseException("name은 10글자까지 작성할 수 있습니다.");
		}
		if (StringUtil.isExceedLength(password, 10)) {
			throw new AjaxResponseException("password는 10글자까지 작성할 수 있습니다.");
		}
		if (StringUtil.isExceedLength(passwordConfirm, 10)) {
			throw new AjaxResponseException("passwordConfirm은 10글자까지 작성할 수 있습니다.");
		}
		if (!StringUtil.isMatchTo(password, passwordConfirm)) {
			throw new AjaxResponseException("password가 일치하지 않습니다.");
		}
		
		boolean isSuccess = memberService.createNewMember(memberVO);
		
		logger.debug("회원 등록 성공 여부 : {}", isSuccess);
		
		Map<String, Object> registResult = new HashMap<>();
		registResult.put("registResult", isSuccess);
		return registResult;
		
	}


}
