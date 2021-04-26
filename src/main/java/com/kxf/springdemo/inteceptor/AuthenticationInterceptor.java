package com.kxf.springdemo.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kxf.springdemo.entity.UserBean;
import com.kxf.springdemo.util.Consts;
import com.kxf.springdemo.util.TokenUtil;
 
public class AuthenticationInterceptor implements HandlerInterceptor {
 
    @Autowired
    private TokenUtil tokenUtils;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter(Consts.COOKIE_NAME_TOKEN);
        UserBean user = tokenUtils.getByToken(token);
        request.setAttribute(Consts.CURRENT_USER, user);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
