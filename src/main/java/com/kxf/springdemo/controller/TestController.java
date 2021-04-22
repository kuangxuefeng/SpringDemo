package com.kxf.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxf.springdemo.entity.SpringTableBean;
import com.kxf.springdemo.service.SpringTableService;

@RestController
public class TestController {
	@Autowired
    private SpringTableService springTableService;

	/**
	 * 查询名称   http://localhost:8080/selectNameById?id=2
	 * @param id
	 * @return
	 */
    @RequestMapping("/selectNameById")
    public String selectNameById(@RequestParam(value="id", defaultValue="1") int id) {
    	SpringTableBean sb = springTableService.select(id);
        return sb.getName();
    }
    
    /**
	 * 查询对象   http://localhost:8080/selectById?id=2
	 * @param id
	 * @return
	 */
    @RequestMapping("/selectById")
    public SpringTableBean selectById(@RequestParam(value="id", defaultValue="1") int id) {
    	SpringTableBean sb = springTableService.select(id);
        return sb;
    }
}
