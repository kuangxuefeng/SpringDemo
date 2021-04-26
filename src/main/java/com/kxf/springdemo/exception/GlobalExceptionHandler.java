package com.kxf.springdemo.exception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.kxf.springdemo.result.CodeMsg;
import com.kxf.springdemo.result.Result;
import com.kxf.springdemo.util.Consts;

/**
 * 统一异常处理
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
    	Result<String> result = null;
    	String reqId=(String) request.getAttribute(Consts.REQ_ID);
    	
        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            result = Result.error(ex.getCm());
        } else if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            result = Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        } else {
        	result = Result.error(CodeMsg.SERVER_ERROR);
        }
        
        result.setReqId(reqId);
        StringBuilder sb = new StringBuilder();
    	sb.append("\n================response==============\n");
    	sb.append("请求id:" + reqId + "\n");
    	sb.append("响应报文:" + JSON.toJSONString(result) + "\n");
    	sb.append("=====================================");
        logger.error(sb.toString(), e);
        return result;
    }
}
