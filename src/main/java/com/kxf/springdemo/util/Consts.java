package com.kxf.springdemo.util;

import java.util.UUID;

public class Consts {

	private Consts() {
	}
	
	/**
     * token过期时间，2天
     * TOKEN_EXPIRE = 3600 * 24 * 2;
     */
    public static final int TOKEN_EXPIRE = 3000;
	
	public static final String CURRENT_USER = "current_user";
	public static final String CURRENT_USER_ID = "current_user_id";
	public static final String COOKIE_NAME_TOKEN = "token";
	public static final String REQ_ID = "req_id";
	
	public static String getUUID() {
		String re = UUID.randomUUID().toString().replace("-", "");
		return re ;
	}
}
