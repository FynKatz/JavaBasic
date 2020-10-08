package com.huyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringBoot 处理异常方式一
 */
@Controller
public class DemoController {
	// 跳转添加页面
	@RequestMapping("/show")
	public String showPage() {
		String str = null;
		str.length();// 会报空指针异常
		return "index";
	}
}