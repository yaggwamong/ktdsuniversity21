package com.ktdsuniversity.admin.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;

public class BlockPageInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//세션이 없는지 체크
		HttpSession session =request.getSession();
		MbrVO member =(MbrVO) session.getAttribute("__ADMIN__");
		
		//세션이 있다 = return false
		if(member !=null) {
			response.sendRedirect(request.getContextPath()+ "/mbr/list");
			return false;
		}
		//세션이 없다 = return true
		return true;
	}

}
