package com.kxf.springdemo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxf.springdemo.dao.UserBeanMapper;
import com.kxf.springdemo.entity.UserBean;
import com.kxf.springdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserBeanMapper mapper;
	
	@Override
	public UserBean select(Integer id) {
		// TODO Auto-generated method stub
		Optional<UserBean> stbs = mapper.selectByPrimaryKey(id);
		return stbs.orElse(null);
	}
	
	@Override
	public int insert(UserBean bean) {
		// TODO Auto-generated method stub
		int re = mapper.insert(bean);
		return re;
	}

}
