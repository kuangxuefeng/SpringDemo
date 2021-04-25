package com.kxf.springdemo.service.impl;

import java.util.Optional;

import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxf.springdemo.dao.UserBeanDynamicSqlSupport;
import com.kxf.springdemo.dao.UserBeanMapper;
import com.kxf.springdemo.entity.UserBean;
import com.kxf.springdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserBeanMapper mapper;

	@Override
	public UserBean selectById(Integer id) {
		Optional<UserBean> stbs = mapper.selectByPrimaryKey(id);
		return stbs.orElse(null);
	}

	@Override
	public int insert(UserBean bean) {
		int re = mapper.insert(bean);
		return re;
	}

	@Override
	public UserBean selectByName(String name) {
		SelectStatementProvider selectStatement = SqlBuilder.select(mapper.selectList)
				.from(UserBeanDynamicSqlSupport.userBean)
				.where(UserBeanDynamicSqlSupport.name, SqlBuilder.isEqualTo(name))
				.build()
				.render(RenderingStrategies.MYBATIS3);
		Optional<UserBean> stbs = mapper.selectOne(selectStatement);
		return stbs.orElse(null);
	}

}
