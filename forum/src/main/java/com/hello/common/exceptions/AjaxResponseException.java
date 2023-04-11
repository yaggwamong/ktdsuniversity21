package com.hello.common.exceptions;

// Ajax 전용 예외 처리를 하기 위한 클래스
public class AjaxResponseException extends RuntimeException {

	private static final long serialVersionUID = -1915517486526260958L;
	
	public AjaxResponseException(String msg) {
		super(msg);
	}

}
