package com.kxf.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kxf.springdemo.result.CodeMsg;
import com.kxf.springdemo.result.Result;

import cn.hutool.core.io.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/file")
@Api(tags = { "文件操作" }, description = "/fileContrllor")
public class FileContrllor {
	
	/**
	 * 文件上传
	 */
	@ApiOperation(value = "文件上传", notes = "文件上传")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Result<String> fileUpload(@RequestParam(value = "file") MultipartFile file) {
		if(file.isEmpty()) {
			return Result.error(CodeMsg.PARAM_EMPTY.fillArgs("file"));
		}
		//获取上传文件的文件名
        String fileName = file.getOriginalFilename();
        //获取存储路径 System.getProperty("user.dir")是获取当前项目的地址
        String savePath = System.getProperty("user.dir")+"/uploadFiles/"+fileName;
        try{
        	//实现文件存储
            FileUtil.writeBytes(file.getBytes(),savePath);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
		return Result.success();
	}
}
