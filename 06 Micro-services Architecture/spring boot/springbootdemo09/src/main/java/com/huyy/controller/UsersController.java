package com.huyy.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huyy.pojo.Users;

/**
 * SpringBoot 表单数据校验
 */
@Controller
public class UsersController {
	// 跳转添加页面
	@RequestMapping("/addUser")
	public String showPage(@ModelAttribute("aa") Users users) {
		return "add";
	}

	/*
	 * 完成用户添加
	 *  @Valid ：开启对Users 对象的数据校验
	 * 	BindingResult:封装了校验的结果
	 * */
	@RequestMapping("/save") 
	public String saveUser(@ModelAttribute("aa") @Valid Users users, BindingResult result) {
		if (result.hasErrors()) {
			return "add";
		}
		System.out.println(users);
		return "ok";
	}
}