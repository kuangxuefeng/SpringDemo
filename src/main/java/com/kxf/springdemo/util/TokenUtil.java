package com.kxf.springdemo.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.kxf.springdemo.entity.UserBean;
import com.kxf.springdemo.exception.GlobalException;
import com.kxf.springdemo.result.CodeMsg;

@Component
public class TokenUtil {
	@Autowired
    private RedisUtil redisUtil;
	
    /**
     * token过期时间，2天
     * TOKEN_EXPIRE = 3600 * 24 * 2;
     */
    public static final int TOKEN_EXPIRE = 3000;
    
    public void addCookie(HttpServletResponse response, String token, UserBean user) {
        //将token写入cookie
        Cookie cookie = new Cookie(Consts.COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    
    public void setToken(String token, UserBean user) {
        //将token存入到redis
        redisUtil.set(Consts.COOKIE_NAME_TOKEN + "::" + token, JSON.toJSONString(user), TOKEN_EXPIRE);
    }
    
    public UserBean getByToken(String token) throws Exception {
        if (!StringUtils.hasText(token)) {
            return null;
        }
        UserBean user = JSON.parseObject(redisUtil.get(Consts.COOKIE_NAME_TOKEN + "::" + token), UserBean.class);
        //重置有效期
        if (user == null) {
            throw new GlobalException(CodeMsg.USER_NOT_LOGIN);
        }
        return user;
    }
}
