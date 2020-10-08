package com.mzd.multipledatasources.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzd.multipledatasources.bean.TeachersBean;
import com.mzd.multipledatasources.bean.TestBean;
import com.mzd.multipledatasources.dao.TransactionDao2;
import com.mzd.multipledatasources.service.TransactionService1;
import com.mzd.multipledatasources.service.TransactionService2;

/**
 * 多数据源事务测试
 * 
 * @author acer
 *
 */
@RequestMapping("/test")
@RestController
public class TransactionController {
	@Autowired
	private TransactionService1 ts1;
	@Autowired
	private TransactionService2 ts2;

	@RequestMapping("/savetest.do")
	public String savetest() {
		
		ts1.test01_saveTestBean();
		return "success";
	}

	@RequestMapping("/saveteacher.do")
	public String saveteacher() {
		
		ts2.test02_saveTestBean();
		return "success";
	}
	
	//事务测试
	@RequestMapping("/test.do")
	public String test() {

		ts1.test01_saveTestBean();
		
		ts2.test02_saveTestBean();
		
		return "success";
	}

	
}
