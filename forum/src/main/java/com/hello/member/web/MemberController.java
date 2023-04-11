package com.hello.member.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hello.common.util.StringUtil;
import com.hello.member.service.MemberService;
import com.hello.member.vo.MemberVO;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/login")
	public String viewLoginPage() {
		return "member/login";
	}
	
	@GetMapping("/member/logout")
	public String doLogOut(HttpSession session) {
		
		// Logout
		session.invalidate();
		
		return "redirect:/member/login";
	}
	
	
	@PostMapping("/member/login")
	public String doLogin(MemberVO memberVO, HttpSession session, Model model) {
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
			// 세션에 데이터 저장
			session.setAttribute("__USER_SESSION_DATA__", memberData);
		}
		else {
			// 로그인 실패
			model.addAttribute("errorcode", "NOT_FOUND_USER");
			return "member/login";
		}
		return "redirect:/topics";
	}
	
	
	@GetMapping("/member/regist")
	public String viewMemberRegistPage() {
		return "member/regist";
	}
	
	// 파라미터를 받아오는 방법 1 : 고전적인 방법 -> 파라미터를 하나하나 다 받아 온다
	// HttpServletRequest : HTTP 프로토콜 요청에 대한 모든 정보들이 들어 있다
//	@PostMapping("/member/regist")
//	public String doMemberRegist(HttpServletRequest request) {
//		// 파라미터 받아오기 - getParameter("이름")
//		// 번거롭기도 하고... 코드도 많이 써야 해서 사용하지 않는다 (이런 게 있다는 것만 알아둘 것)
//		String email = request.getParameter("email");
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		
//		MemberVO member = new MemberVO();
//		member.setEmail(email);
//		member.setName(name);
//		member.setPassword(password);
//		
//		boolean isSuccess = memberService.createNewMember(member);
//		System.out.println("회원등록 성공 여부 : " + isSuccess);
//		
//		return "redirect:/member/regist";  // /forum/member/regist 로 URL을 이동시킨다.
//	}
	
	// 파라미터를 받아오는 방법 2 : @RequestParam 을 통해 받아오기
	// 1번의 간소화 버전으로, 받아올 것이 2~3개 쯤으로 적을 때 종종 사용한다
	// form에 있는 것들의 id를 적어 주면 되는데, 가끔 이름을 다르게 적어야 할 때가 있다
	// 그럴 때는 RequestParam("password") String pwd 와 같은 방식으로 적으면 사용 가능하다
//	@PostMapping("/member/regist")
//	public String doMemberRegist(@RequestParam String email,
//			                     @RequestParam String name,
//			                     @RequestParam("password") String pwd) {
//		
//		MemberVO member = new MemberVO();
//		member.setEmail(email);
//		member.setName(name);
//		member.setPassword(pwd);
//		
//		boolean isSuccess = memberService.createNewMember(member);
//		System.out.println("회원 등록 성공 여부 : " + isSuccess);
//		
//		if (!isSuccess) {
//			return "redirect:https://naver.com";
//		}
//		return "redirect:/member/regist";
//	}
	
	// 파라미터를 받아오는 방법 3 : 커맨드 객체
	// 제일 많이 쓰는 방법 - 받아올 데이터가 몇 개 없을 때는 2번 방법을 사용한다
	@PostMapping("/member/regist")
	public String doMemeberRegist(MemberVO memberVO) {
		
		String email = memberVO.getEmail();
		String name = memberVO.getName();
		String password = memberVO.getPassword();
		String passwordConfirm = memberVO.getPasswordConfirm();
		
		if (StringUtil.isEmpty(email)) {
			throw new RuntimeException("email은 필수 값 입니다.");
		}
		if (StringUtil.isEmpty(name)) {
			throw new RuntimeException("name은 필수 값 입니다.");
		}
		if (StringUtil.isEmpty(password)) {
			throw new RuntimeException("password은 필수 값 입니다.");
		}
		if (StringUtil.isEmpty(passwordConfirm)) {
			throw new RuntimeException("passwordConfirm은 필수 값 입니다.");
		}
		if (StringUtil.isExceedLength(email, 100)) {
			throw new RuntimeException("email은 100글자까지 작성할 수 있습니다.");
		}
		if (StringUtil.isExceedLength(name, 10)) {
			throw new RuntimeException("name은 10글자까지 작성할 수 있습니다.");
		}
		if (StringUtil.isExceedLength(password, 10)) {
			throw new RuntimeException("password는 10글자까지 작성할 수 있습니다.");
		}
		if (StringUtil.isExceedLength(passwordConfirm, 10)) {
			throw new RuntimeException("passwordConfirm은 10글자까지 작성할 수 있습니다.");
		}
		if (!StringUtil.isMatchTo(password, passwordConfirm)) {
			throw new RuntimeException("password가 일치하지 않습니다.");
		}
		
		boolean isSuccess = memberService.createNewMember(memberVO);
		
		logger.debug("회원 등록 성공 여부 : {}", isSuccess);
		
		return "redirect:/member/regist";
	}
	
	

}
