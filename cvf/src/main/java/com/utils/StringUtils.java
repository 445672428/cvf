package com.utils;


public class StringUtils {
	public static String trim(Object obj){
		return obj ==null?"":obj.toString().trim();
	}
	public static boolean isEmpty(Object obj) {
		return (obj == null || "".equals(obj));
	}
}
