package com.kxf.springdemo.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.kxf.springdemo.util.Consts;

public class ReqIdInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ThreadLocal<Long> threadLocal = new ThreadLocal<>();
 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	logger.info("ReqIdInterceptor preHandle==>>");
    	threadLocal.set(System.currentTimeMillis());
    	String reqId = Consts.getUUID();
    	StringBuilder sb = new StringBuilder();
    	sb.append("\n================request===============\n");
    	sb.append("请求id:" + reqId + "\n");
    	sb.append("请求接口:" + request.getRequestURI() + "\n");
    	sb.append("请求参数:" + JSON.toJSONString(request.getParameterMap()) + "\n");
    	sb.append("=====================================");
        request.setAttribute(Consts.REQ_ID, reqId);
        logger.info(sb.toString());
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	logger.info("ReqIdInterceptor postHandle==>>");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    	logger.info("ReqIdInterceptor afterCompletion==>>");
    	String reqId=(String) request.getAttribute(Consts.REQ_ID);
    	StringBuilder sb = new StringBuilder();
    	sb.append("\n================耗时==============\n");
    	sb.append("请求id:" + reqId + "\n");
    	sb.append("耗时:" + (System.currentTimeMillis() - threadLocal.get()) + "ms\n");
    	sb.append("=====================================");
    	logger.info(sb.toString());
    }
}
