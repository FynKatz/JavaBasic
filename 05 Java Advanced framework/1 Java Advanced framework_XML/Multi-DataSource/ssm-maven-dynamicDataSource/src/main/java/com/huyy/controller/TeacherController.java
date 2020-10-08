package com.huyy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huyy.beans.Teacher;
import com.huyy.service.TeacherService;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping(value = "/teacherController")
public class TeacherController {

	@Resource
	private TeacherService teacherService;
	
	/**
	 * 1.查找全部的教师（查询数据源1）
	 * @return
	 */
	@RequestMapping(value = "/getAllTeachers", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public ResponseEntity<String> getAllTeachers() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("access-control-allow-origin", "*");
		Map<String, Object> result = new HashMap<String, Object>();
		JSONObject jsonObj;

		try {
			List<Teacher> list = teacherService.getAllTeachers();
			result.put("success", true);
			result.put("data", list);
			JsonConfig cfg = new JsonConfig();
			jsonObj = JSONObject.fromObject(result, cfg);
			return new ResponseEntity<String>(jsonObj.toString(), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("errorInfo", e.getMessage());
			jsonObj = JSONObject.fromObject(result);
			return new ResponseEntity<String>(jsonObj.toString(), headers, HttpStatus.OK);
		}
	}
	
	/**
	 * 2.按名称查找教师（查询数据源2）
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/getTeacherByName", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public ResponseEntity<String> getTeacherByName(String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("access-control-allow-origin", "*");
		Map<String, Object> result = new HashMap<String, Object>();
		JSONObject jsonObj;

		try {
			List<Teacher> list = teacherService.getTeacherByName(name);
			result.put("success", true);
			result.put("data", list);
			JsonConfig cfg = new JsonConfig();
			jsonObj = JSONObject.fromObject(result, cfg);
			return new ResponseEntity<String>(jsonObj.toString(), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("errorInfo", e.getMessage());
			jsonObj = JSONObject.fromObject(result);
			return new ResponseEntity<String>(jsonObj.toString(), headers, HttpStatus.OK);
		}
	}
}
