package com.kxf.springdemo.util;

import java.util.UUID;

public class Consts {

	private Consts() {
	}
	
	public static final String CURRENT_USER = "current_user";
	public static final String COOKIE_NAME_TOKEN = "token";
	public static final String REQ_ID = "req_id";
	
	public static String getUUID() {
		String re = UUID.randomUUID().toString().replace("-", "");
		return re ;
	}
}
