package com.kxf.springdemo.service;

import com.kxf.springdemo.entity.UserBean;

public interface UserService {
	UserBean select(Integer id);

	int insert(UserBean bean);
}
