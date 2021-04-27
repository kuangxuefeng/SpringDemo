package com.kxf.springdemo.properties;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@Configuration
//@EnableConfigurationProperties(MyAppInfoProperties.class)
//@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "spring.my-app-info")
public class MyAppInfoProperties implements BeanClassLoaderAware, InitializingBean {
	private String name;
	private String version;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		// TODO Auto-generated method stub
		
	}
	
	
}
