package com.kxf.springdemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringDemoApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(SpringDemoApplication.class);
		logger.error("开始启动服务===>>>");
		ConfigurableApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);
		String serverPort = context.getEnvironment().getProperty("server.port");
		String contextPath = context.getEnvironment().getProperty("server.servlet.context-path");
		String serverIp = getIp();
		logger.error("服务启动完成===>>>");
		logger.error("接口文档地址(内网)===>>>  " + "http://localhost:" + serverPort + contextPath + "/swagger-ui.html");
		logger.error("接口文档地址(外网)===>>>  " + serverIp + ":" + serverPort + contextPath + "/swagger-ui.html");
	}

	public static String getIp() {
		String ipStr = "http://";
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
			ipStr = ipStr + address.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ipStr;
	}

}
