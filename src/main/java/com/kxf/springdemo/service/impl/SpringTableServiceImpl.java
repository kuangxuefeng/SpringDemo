package com.kxf.springdemo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxf.springdemo.dao.SpringTableBeanMapper;
import com.kxf.springdemo.entity.SpringTableBean;
import com.kxf.springdemo.service.SpringTableService;

@Service
public class SpringTableServiceImpl implements SpringTableService {

	@Autowired
    private SpringTableBeanMapper mapper;
	
	@Override
	public SpringTableBean select(Integer id) {
		// TODO Auto-generated method stub
		Optional<SpringTableBean> stbs = mapper.selectByPrimaryKey(id);
		return stbs.orElse(null);
	}

}
