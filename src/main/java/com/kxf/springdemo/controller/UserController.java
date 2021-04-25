package com.kxf.springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxf.springdemo.entity.UserBean;
import com.kxf.springdemo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
@Api(tags = {"user操作"}, description = "/user")
public class UserController {
	@Autowired
    private UserService springTableService;
	
	Logger logger=LoggerFactory.getLogger(UserController.class);

	/**
	 * 查询名称   http://localhost:8080/user/selectNameById?id=2
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询名称", notes = "查询名称")
    @RequestMapping(value = "/selectNameById", method=RequestMethod.GET)
    public String selectNameById(@ApiParam(value="用户id", defaultValue="1") @RequestParam(value="id", defaultValue="1") int id) {
		UserBean sb = springTableService.select(id);
        return sb.getName();
    }
    
    /**
	 * 查询对象   http://localhost:8080/user/selectById?id=2
	 */
	@ApiOperation(value = "查询对象", notes = "查询对象")
	@RequestMapping(value = "/selectById", method=RequestMethod.GET)
    public UserBean selectById(@ApiParam(value="用户id", defaultValue="1") @RequestParam(value="id", defaultValue="1") int id) {
		UserBean sb = springTableService.select(id);
        return sb;
    }
    
    /**
	 * 增加对象   http://localhost:8080/user/add?name=tom
	 */
	@ApiOperation(value = "增加对象", notes = "增加对象")
	@RequestMapping(value = "/add", method=RequestMethod.GET)
    public String addUser(@ApiParam(value="用户名称", defaultValue="") @RequestParam(value="name", defaultValue="") String name, @ApiParam(value="用户备注", defaultValue="") @RequestParam(value="info", defaultValue="") String info) {
		logger.info("addUser===>>>");
		logger.error("addUser===>>>");
    	String re = "fail";
    	if (name!=null && name.length()>0) {
    		UserBean sBean = new UserBean();
    		sBean.setName(name);
    		sBean.setInfo(info);
    		sBean.setPw(name);
    		int i = springTableService.insert(sBean);
    		if (i>0) {
    			re = "success";
			}
		}
        return re;
    }
}
