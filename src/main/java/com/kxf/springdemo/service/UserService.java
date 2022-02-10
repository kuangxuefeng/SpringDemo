package com.kxf.springdemo.service;

import com.kxf.springdemo.entity.UserBean;

public interface UserService {
	UserBean selectById(Integer id);

	int insert(UserBean bean);
	
	UserBean selectByName(String name);
}
