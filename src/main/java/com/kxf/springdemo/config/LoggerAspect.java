package com.kxf.springdemo.config;

import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.kxf.springdemo.result.Result;
import com.kxf.springdemo.util.Consts;

@Aspect
@Configuration
public class LoggerAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 定义切点Pointcut
	@Pointcut("execution(* com.kxf.springdemo.controller..*.*(..))")
	public void executeService() {
	}

	@Around("executeService()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("LoggerAspect doAround==>>");
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		String reqId=(String) request.getAttribute(Consts.REQ_ID);

		// result的值就是被拦截方法的返回值
		Object result = pjp.proceed();
		
		if (StringUtils.hasText(reqId) && result instanceof Result<?>) {
			((Result<?>) result).setReqId(reqId);
		}
		
		StringBuilder sb = new StringBuilder();
    	sb.append("\n================response==============\n");
    	sb.append("请求id:" + reqId + "\n");
    	sb.append("响应报文:" + JSON.toJSONString(result) + "\n");
    	sb.append("=====================================");
    	
		logger.info(sb.toString());
		return result;
	}

}
