package com.kxf.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxf.springdemo.entity.SpringTableBean;
import com.kxf.springdemo.service.SpringTableService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/springTable")
@Api(tags = "springTable读写")
public class TestController {
	@Autowired
    private SpringTableService springTableService;

	/**
	 * 查询名称   http://localhost:8080/springTable/selectNameById?id=2
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询名称", notes = "查询名称")
    @RequestMapping(value = "/selectNameById", method=RequestMethod.GET)
    public String selectNameById(@ApiParam(value="用户id", defaultValue="1") @RequestParam(value="id", defaultValue="1") int id) {
    	SpringTableBean sb = springTableService.select(id);
        return sb.getName();
    }
    
    /**
	 * 查询对象   http://localhost:8080/springTable/selectById?id=2
	 */
	@ApiOperation(value = "查询对象", notes = "查询对象")
	@RequestMapping(value = "/selectById", method=RequestMethod.GET)
    public SpringTableBean selectById(@ApiParam(value="用户id", defaultValue="1") @RequestParam(value="id", defaultValue="1") int id) {
    	SpringTableBean sb = springTableService.select(id);
        return sb;
    }
    
    /**
	 * 增加对象   http://localhost:8080/springTable/addUser?name=tom
	 */
	@ApiOperation(value = "增加对象", notes = "增加对象")
	@RequestMapping(value = "/addUser", method=RequestMethod.GET)
    public String addUser(@ApiParam(value="用户名称", defaultValue="") @RequestParam(value="name", defaultValue="") String name, @ApiParam(value="用户备注", defaultValue="") @RequestParam(value="info", defaultValue="") String info) {
    	String re = "fail";
    	if (name!=null && name.length()>0) {
    		SpringTableBean sBean = new SpringTableBean();
    		sBean.setName(name);
    		sBean.setInfo(info);
    		int i = springTableService.insert(sBean);
    		if (i>0) {
    			re = "success";
			}
		}
        return re;
    }
}
