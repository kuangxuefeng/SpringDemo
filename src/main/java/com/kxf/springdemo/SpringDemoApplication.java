package com.kxf.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringDemoApplication {

	public static void main(String[] args) {
		Logger logger=LoggerFactory.getLogger(SpringDemoApplication.class);
		logger.error("开始启动服务===>>>");
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
