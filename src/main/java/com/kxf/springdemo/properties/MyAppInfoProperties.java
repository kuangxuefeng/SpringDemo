package com.kxf.springdemo.properties;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

//@Configuration
//@EnableConfigurationProperties(MyAppInfoProperties.class)
//@PropertySource("classpath:application.properties")
@Data
@Component
@ConfigurationProperties(prefix = "spring.my-app-info")
public class MyAppInfoProperties implements BeanClassLoaderAware, InitializingBean {
	private String name;
	private String version;
	private String buildTimestamp;
	private String logPathChild;//日志存放目录
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		// TODO Auto-generated method stub
		
	}
	
}
