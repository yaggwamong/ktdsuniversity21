package com.hello.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hello.member.vo.MemberVO;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//세션 개체 가져오기
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("__USER_SESSION_DATA__");
		
		if (member == null) {
			// 이건 스프링 문법이 아니라 Servlet 문법이라서 ContextPath가 뭔지 모른다 -> 직접 붙여줘야 함!!
			response.sendRedirect(request.getContextPath() + "/member/login");
			return false;
		}
		return true; // controller를 계속 실행한다
	}

}
