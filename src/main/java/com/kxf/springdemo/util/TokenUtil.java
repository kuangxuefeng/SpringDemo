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
	
    
    public static final String TOKEN_SPLIT = "#";
    
    public void addCookie(HttpServletResponse response, String token) {
        //将token写入cookie
        Cookie cookie = new Cookie(Consts.COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(Consts.TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    
    public String setToken(String tokenValue, UserBean user) {
        //将token存入到redis
        redisUtil.set(Consts.COOKIE_NAME_TOKEN + "::" + user.getId(), tokenValue, Consts.TOKEN_EXPIRE);
        return user.getId() + TOKEN_SPLIT + tokenValue;
    }
    
    public Integer getUserIdByToken(String token) throws Exception {
        if (!StringUtils.hasText(token)) {
        	throw new GlobalException(CodeMsg.TOKEN_INVALID);
        }
        int index = token.indexOf(TOKEN_SPLIT);
        if (index<0 || index == token.length()-1) {
        	throw new GlobalException(CodeMsg.TOKEN_INVALID);
		}
        String key = token.substring(0, index);
        String tokenLoc = redisUtil.get(Consts.COOKIE_NAME_TOKEN + "::" + key);
        if (!StringUtils.hasText(tokenLoc)) {
        	throw new GlobalException(CodeMsg.TOKEN_INVALID);
		}
        
        String tokenVal = token.substring(index+1);
        if (!tokenLoc.equals(tokenVal)) {
        	throw new GlobalException(CodeMsg.TOKEN_INVALID);
		}
        Integer keyInt;
		try {
			keyInt = Integer.parseInt(key);
		} catch (Exception e) {
			throw new GlobalException(CodeMsg.TOKEN_INVALID);
		}
        return keyInt;
    }
}
