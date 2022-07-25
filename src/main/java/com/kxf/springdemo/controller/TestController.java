package com.kxf.springdemo.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxf.springdemo.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/test")
@Api(tags = { "测试接口" }, description = "/test")
public class TestController {
	/**
	 * 当前用户
	 */
	@ApiOperation(value = "模拟延迟响应", notes = "模拟延迟响应")
	@RequestMapping(value = "/postDelay", method = RequestMethod.POST)
	public Result<HashMap<String, String>> postDelay(@ApiParam(value = "延迟响应的毫秒数", defaultValue = "0") @RequestParam(value = "delayTimeMilli", defaultValue = "0") Long delayTimeMilli,
			@ApiParam(value = "备注字段，原样返回", defaultValue = "") @RequestParam(value = "reserved", defaultValue = "") String reserved) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("reserved", reserved);
		map.put("time", System.currentTimeMillis()+"");
		try {
			Thread.sleep(delayTimeMilli);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Result.success(map);
	}
}
