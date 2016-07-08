package org.lee.spring.hibernate.util;

import java.lang.reflect.Method;

import org.lee.spring.hibernate.model.LibAuth;

import com.opensymphony.xwork2.ActionContext;

public class ActionUtil {
	public static final String REDIRECT="redirect";
	public static final String AUTH_READER="reader";
	public static final String AUTH_BOOK="book";
	public static final String AUTH_GET="get";
	public static boolean isEmpty(String field){
		if(field==null||"".equals(field.trim())) return true;
		return false;
	}
	public static void RedirectURL(String url) {
		ActionContext.getContext().put("url", url);
	}
	/**
	 * 判断该用户是否有权限访问该功能
	 * @param method
	 * @param r
	 * @param a
	 * @return 返回0则代表无法访问，返回1代表是读者功能，返回2代表入库功能，返回三代表借阅管理功能
	 */
	public static int interceptorAuth(Method method) {
		if(method.isAnnotationPresent(LibAuth.class)&&method.getAnnotation(LibAuth.class).value().equals(AUTH_READER)) {
			return 1;
		}
		if(method.isAnnotationPresent(LibAuth.class)&&method.getAnnotation(LibAuth.class).value().equals(AUTH_BOOK)) {
			return 2;
		}
		if(method.isAnnotationPresent(LibAuth.class)&&method.getAnnotation(LibAuth.class).value().equals(AUTH_GET)) {
			return 3;
		}
		return 0;
	}

}
