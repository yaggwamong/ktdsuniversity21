package com.ktdsuniversity.admin.common.api.exceptions;

public class ApiArgsException extends ApiException{

	// 파라미터가 비어있다면 아그스 익셉션을 던진다. 
	private static final long serialVersionUID = -6134504930900766840L;

	public ApiArgsException(String errorCode, String message) {
		super(errorCode, message);
		
	}

}
