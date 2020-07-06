package com.huyy.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * SpringBoot文件上传
 *
 *
 */
@RestController //表示该类下的方法的返回值会自动做json格式的转换
public class FileUploadController {

	/*
	 * 处理文件上传
	 */            //URL对应HTML中上传表单的目标地址
	@RequestMapping("/fileUploadController")         //filename是HTML中传入的名称，名称必须一致
	public Map<String, Object> fileUpload(MultipartFile filename)throws Exception{
		System.out.println(filename.getOriginalFilename());//打印文件的名称
		filename.transferTo(new File("C:/"+filename.getOriginalFilename()));//上传文件
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "ok");
		return map;
	}
}
