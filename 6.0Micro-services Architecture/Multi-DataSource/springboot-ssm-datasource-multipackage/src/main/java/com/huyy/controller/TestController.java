package com.huyy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huyy.service.MysqlService;
import com.huyy.service.PgsqlService;

/**
 * 多数据源事务测试
 * 
 * @author acer
 *
 */
@RequestMapping("/test")
@RestController
public class TestController {
		
	@Autowired
	private MysqlService mysqlService;
	
	@Autowired
	private PgsqlService pgsqlService;

	
	/**
	 * 事务测试
	 * @return
	 * http://localhost:8081/datasourcetest/test/test.do
	 */
	@RequestMapping("/test.do")
	public String test() {

		mysqlService.savetestBean();		
		pgsqlService.saveTeacher();		
		return "success";
	}

}
