package com.ktdsuniversity.admin.common.api.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ktdsuniversity.admin.common.api.exceptions.ApiArgsException;
import com.ktdsuniversity.admin.common.api.exceptions.ApiException;
import com.ktdsuniversity.admin.common.api.vo.ApiResponseVO;
import com.ktdsuniversity.admin.common.api.vo.ApiStatus;

@RestControllerAdvice("com.ktdsuniversity.admin")  // 밑에 리스폰스 바디를 적을 필요가 없다. 
public class GlobalApiExceptionHandler {
	
	@ExceptionHandler(ApiArgsException.class)
	public ApiResponseVO handlerApiArgsException(ApiException ae) {  //파라미터가 비어있으면 자동으로 던져주는 에러 
		return new ApiResponseVO(ApiStatus.MISSING_ARGS, ae.getMessage(), ae.getErrorCode(), "");	
	}
	
	@ExceptionHandler(ApiException.class)
	public ApiResponseVO handlerApiException(ApiException ae) {
		return new ApiResponseVO(ApiStatus.FAIL, ae.getMessage(), ae.getErrorCode(), "");
	}
}
