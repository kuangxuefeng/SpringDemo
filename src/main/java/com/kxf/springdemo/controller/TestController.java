package com.kxf.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxf.springdemo.entity.SpringTableBean;
import com.kxf.springdemo.service.SpringTableService;

@RestController
@RequestMapping("/springTable")
public class TestController {
	@Autowired
    private SpringTableService springTableService;

	/**
	 * 查询名称   http://localhost:8080/springTable/selectNameById?id=2
	 * @param id
	 * @return
	 */
    @RequestMapping("/selectNameById")
    public String selectNameById(@RequestParam(value="id", defaultValue="1") int id) {
    	SpringTableBean sb = springTableService.select(id);
        return sb.getName();
    }
    
    /**
	 * 查询对象   http://localhost:8080/springTable/selectById?id=2
	 */
    @RequestMapping("/selectById")
    public SpringTableBean selectById(@RequestParam(value="id", defaultValue="1") int id) {
    	SpringTableBean sb = springTableService.select(id);
        return sb;
    }
    
    /**
	 * 增加对象   http://localhost:8080/springTable/addUser?name=tom
	 */
    @RequestMapping("/addUser")
    public String addUser(@RequestParam(value="name", defaultValue="") String name, @RequestParam(value="info", defaultValue="") String info) {
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
