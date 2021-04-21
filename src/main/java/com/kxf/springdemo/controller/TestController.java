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
	 * 查询   http://localhost:8080/select?id=2
	 * @param id
	 * @return
	 */
    @RequestMapping("/select")
    public String select(@RequestParam(value="id", defaultValue="1") int id) {
    	SpringTableBean sb = springTableService.select(id);
        return sb.getName();
    }
}
