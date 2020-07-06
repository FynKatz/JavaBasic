package com.huyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Thymeleaf 入门案例
 *
 *
 */
@Controller
public class DemoController {

	@RequestMapping("/show")
	public String showInfo(Model model) {
		model.addAttribute("msg", "Thymeleaf 第一个案例");
		return "index";
	}

	@RequestMapping("/show3")
	public String showInfo3(Model model) {
		List<Users> list = new ArrayList<>();
		list.add(new Users(1, "张三", 20));
		list.add(new Users(2, "李四", 22));
		list.add(new Users(3, "王五", 24));
		model.addAttribute("list", list);
		return "index3";
	}
}