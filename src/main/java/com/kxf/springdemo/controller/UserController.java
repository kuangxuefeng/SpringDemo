package com.kxf.springdemo.controller;

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
import com.kxf.springdemo.util.Consts;
import com.kxf.springdemo.util.TokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/user")
@Api(tags = { "用户操作" }, description = "/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private TokenUtil tokenUtil;

	Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 登录
	 */
	@ApiOperation(value = "用户登录", notes = "用户登录")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Result<String> login(HttpServletResponse response,
			@ApiParam(value = "用户名称", defaultValue = "") @RequestParam(value = "name", defaultValue = "") String name,
			@ApiParam(value = "用户密码", defaultValue = "") @RequestParam(value = "pw", defaultValue = "") String pw) {
		UserBean ub = userService.selectByName(name);
		if (ub != null && StringUtils.hasText(pw) && pw.equals(ub.getPw())) {
			// 生成token
			String tokenVal = Consts.getUUID();
			String token = tokenUtil.setToken(tokenVal, ub);
			tokenUtil.addCookie(response, token);
			return Result.success(token);
		}
		return Result.error(CodeMsg.USERNAME_NOT_EXIST);
	}

	/**
	 * 登录
	 */
	@ApiOperation(value = "用户登录", notes = "用户登录")
	@RequestMapping(value = "/logOut", method = RequestMethod.POST)
	public Result<String> logOut(@ApiIgnore() Integer userId,
			@ApiParam(value = "token", defaultValue = "") @RequestParam(value = "token", defaultValue = "") String token) {
		tokenUtil.del(userId);
		return Result.success();
	}

	/**
	 * 当前用户
	 */
	@ApiOperation(value = "当前用户", notes = "当前用户")
	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public Result<UserBean> current(@ApiIgnore() Integer userId,
			@ApiParam(value = "token", defaultValue = "") @RequestParam(value = "token", defaultValue = "") String token) {
		if (userId != null) {
			UserBean ub = userService.selectById(userId);
			if (ub != null) {
				ub.setPw(null);
				return Result.success(ub);
			}
		}
		return Result.error(CodeMsg.USER_NOT_LOGIN);
	}

	/**
	 * 查询名称
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询名称", notes = "查询名称")
	@RequestMapping(value = "/selectNameById", method = RequestMethod.GET)
	public Result<String> selectNameById(@ApiIgnore() Integer userId,
			@ApiParam(value = "token", defaultValue = "") @RequestParam(value = "token", defaultValue = "") String token,
			@ApiParam(value = "用户id", defaultValue = "1") @RequestParam(value = "id", defaultValue = "1") int id) {
		UserBean ub = userService.selectById(id);
		if (ub!=null) {
			ub.setPw(null);
		}
		return Result.success(ub.getName());
	}

	/**
	 * 查询对象
	 */
	@ApiOperation(value = "查询对象", notes = "查询对象")
	@RequestMapping(value = "/selectById", method = RequestMethod.GET)
	public Result<UserBean> selectById(@ApiIgnore() Integer userId, @ApiParam(value="token", defaultValue="") @RequestParam(value="token", defaultValue="") String token,
			@ApiParam(value = "用户id", defaultValue = "1") @RequestParam(value = "id", defaultValue = "1") int id) {
		UserBean ub = userService.selectById(id);
		if (ub!=null) {
			ub.setPw(null);
		}
		return Result.success(ub);
	}

	/**
	 * 增加对象
	 */
	@ApiOperation(value = "增加对象", notes = "增加对象")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result<String> addUser(
			@ApiParam(value = "token", defaultValue = "") @RequestParam(value = "token", defaultValue = "") String token,
			@ApiParam(value = "用户名称", defaultValue = "") @RequestParam(value = "name", defaultValue = "") String name,
			@ApiParam(value = "用户密码", defaultValue = "") @RequestParam(value = "pw", defaultValue = "") String pw,
			@ApiParam(value = "用户备注", defaultValue = "") @RequestParam(value = "info", defaultValue = "") String info) {
		logger.info("addUser===>>>");
		logger.error("addUser===>>>");
		String re = "fail";
		if (name != null && name.length() > 0) {
			UserBean sBean = new UserBean();
			sBean.setName(name);
			sBean.setInfo(info);
			sBean.setPw(pw);
			int i = userService.insert(sBean);
			if (i > 0) {
				re = "success";
			}
		}
		return Result.success(re);
	}
}
