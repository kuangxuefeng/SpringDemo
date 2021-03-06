package com.kxf.springdemo.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kxf.springdemo.entity.UserBean;
import com.kxf.springdemo.util.Consts;
import com.kxf.springdemo.util.TokenUtil;
 
public class AuthenticationInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @Autowired
    private TokenUtil tokenUtils;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	logger.info("AuthenticationInterceptor preHandle==>>");
        String token = request.getParameter(Consts.COOKIE_NAME_TOKEN);
        Integer userId = tokenUtils.getUserIdByToken(token, true);
        request.setAttribute(Consts.CURRENT_USER_ID, userId);
        logger.info("AuthenticationInterceptor preHandle==>>" + userId);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	logger.info("AuthenticationInterceptor postHandle==>>{}", modelAndView);
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    	logger.info("AuthenticationInterceptor afterCompletion==>>");
    }
}
