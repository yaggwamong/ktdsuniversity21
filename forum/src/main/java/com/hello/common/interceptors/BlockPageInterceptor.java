package com.hello.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hello.member.vo.MemberVO;

public class BlockPageInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("__USER_SESSION_DATA__");
		
		// 세션이 없는지 체크
		// 세션이 있다 -> return false
		if (member != null) {
			response.sendRedirect(request.getContextPath() + "/topics");
			return false;
		}
		
		//세션이 없다 -> return true
		return true;
	}

}
