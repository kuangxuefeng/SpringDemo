package com.kxf.springdemo.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxf.springdemo.entity.UserBean;
import com.kxf.springdemo.result.CodeMsg;
import com.kxf.springdemo.result.Result;
import com.kxf.springdemo.service.UserService;
import com.kxf.springdemo.util.TokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
@Api(tags = {"user操作"}, description = "/user")
public class UserController {
	@Autowired
    private UserService userService;
	
	@Autowired
    private TokenUtil tokenUtil;
	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	/**
	 * 登录
	 */
	@ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public Result<String> login(HttpServletResponse response,
    		@ApiParam(value="用户名称", defaultValue="") @RequestParam(value="name", defaultValue="") String name,
    		@ApiParam(value="用户密码", defaultValue="") @RequestParam(value="pw", defaultValue="") String pw) {
		UserBean ub = userService.selectByName(name);
		if (ub!=null && StringUtils.hasText(pw) && pw.equals(ub.getPw())) {
			//生成cookie
	        String token = UUID.randomUUID().toString().replace("-", "");
	        tokenUtil.addCookie(response, token, ub);
//	        tokenUtil.setToken(token, ub);
			return Result.success(token);
		}
        return Result.error(CodeMsg.USERNAME_NOT_EXIST);
    }

	/**
	 * 查询名称   http://localhost:8080/user/selectNameById?id=2
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询名称", notes = "查询名称")
    @RequestMapping(value = "/selectNameById", method=RequestMethod.GET)
    public Result<String> selectNameById(@ApiParam(value="用户id", defaultValue="1") @RequestParam(value="id", defaultValue="1") int id) {
		UserBean sb = userService.selectById(id);
        return Result.success(sb.getName());
    }
    
    /**
	 * 查询对象   http://localhost:8080/user/selectById?id=2
	 */
	@ApiOperation(value = "查询对象", notes = "查询对象")
	@RequestMapping(value = "/selectById", method=RequestMethod.GET)
    public Result<UserBean> selectById(@ApiParam(value="用户id", defaultValue="1") @RequestParam(value="id", defaultValue="1") int id) {
		UserBean sb = userService.selectById(id);
        return Result.success(sb);
    }
    
    /**
	 * 增加对象   http://localhost:8080/user/add?name=tom
	 */
	@ApiOperation(value = "增加对象", notes = "增加对象")
	@RequestMapping(value = "/add", method=RequestMethod.GET)
    public Result<String> addUser(@ApiParam(value="用户名称", defaultValue="") @RequestParam(value="name", defaultValue="") String name, @ApiParam(value="用户备注", defaultValue="") @RequestParam(value="info", defaultValue="") String info) {
		logger.info("addUser===>>>");
		logger.error("addUser===>>>");
    	String re = "fail";
    	if (name!=null && name.length()>0) {
    		UserBean sBean = new UserBean();
    		sBean.setName(name);
    		sBean.setInfo(info);
    		sBean.setPw(name);
    		int i = userService.insert(sBean);
    		if (i>0) {
    			re = "success";
			}
		}
        return Result.success(re);
    }
}
