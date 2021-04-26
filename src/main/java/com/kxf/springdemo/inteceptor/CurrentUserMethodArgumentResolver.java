package com.kxf.springdemo.inteceptor;

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
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(UserBean.class);
    }
 
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        return  (UserBean) webRequest.getAttribute(Consts.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
    }
}
