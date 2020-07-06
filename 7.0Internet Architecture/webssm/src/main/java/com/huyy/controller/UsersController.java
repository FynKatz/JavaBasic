package com.huyy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huyy.pojo.Users;
import com.huyy.service.UsersService;

@Controller
public class UsersController {
	@Resource
	private UsersService usersService;
	
	@RequestMapping("show")
	public String show(Model model){
		List<Users> list=usersService.show();
		model.addAttribute("list",list);
		return "index.jsp";
	}
}
