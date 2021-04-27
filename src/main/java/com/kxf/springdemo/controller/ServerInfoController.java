package com.kxf.springdemo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kxf.springdemo.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/server")
@Api(tags = { "服务接口信息" }, description = "/server")
public class ServerInfoController {
	
	@Value("${spring.my-app-info.version}")
	private String version;
	
	@Value("${spring.my-app-info.name}")
	private String name;
	
	@Value("${spring.my-app-info.build-timestamp}")
	private String buildTimestamp;
	
	/**
	 * 获取服务端信息
	 */
	@ApiOperation(value = "获取服务端信息", notes = "获取服务端信息")
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public Result<HashMap<String, String>> getInfo(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("version", version);
		map.put("name", name);
		map.put("buildTimestamp", buildTimestamp);
		return Result.success(map);
	}
}
