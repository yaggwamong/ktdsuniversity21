package com.hello.common.exceptionhandler;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.common.exceptions.AjaxResponseException;

// com.hello와 org.springframework 아래에서 발생하는 모든 예외들을 처리하겠다
@ControllerAdvice({"com.hello", "org.springframework"})
public class GlobalExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(AjaxResponseException.class)
	@ResponseBody
	public Map<String, Object> HandleAjaxResponseException(AjaxResponseException are) {
		Map<String, Object> ajaxError = new HashMap<>();
		ajaxError.put("status", "fail");
		ajaxError.put("message", are.getMessage());
		return ajaxError;
	}
	
	
	// 이것만 있으면 Ajax 요청을 해도 화면을 준다 -> json으로 받기 위해서는 위의 HandleAjaxResponseException 이 필요하다!
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException re, Model model) {
		logger.info("예외가 발생했습니다!! : {}", re.getMessage() );
		model.addAttribute("message",re.getMessage());
		return "errors/500";
	}
	

}
