package com.kxf.springdemo.inteceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.kxf.springdemo.entity.UserBean;
import com.kxf.springdemo.util.Consts;
 
 
/**
 * @CurrentUser 注解 解析器
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
    	logger.info("CurrentUserMethodArgumentResolver supportsParameter==>>");
        return parameter.getParameterType().isAssignableFrom(UserBean.class);
    }
 
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
    	logger.info("CurrentUserMethodArgumentResolver resolveArgument==>>");
        return  (UserBean) webRequest.getAttribute(Consts.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
    }
}
