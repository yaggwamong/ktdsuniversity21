package com.hello.common.util;

public class StringUtil {
	
	//생성자 호출 막기
	private StringUtil() {}
	
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}
	
	public static boolean isExceedLength(String str, int maxlength) {
		if (!isEmpty(str)) {
			return str.trim().length() > maxlength;
		}
		return false;
	}
	
	public static boolean isNull(String str) {
		return str == null;
	}
	
	public static boolean isMatchTo(String str, String other) {
		return str.equals(other);
	}

}
