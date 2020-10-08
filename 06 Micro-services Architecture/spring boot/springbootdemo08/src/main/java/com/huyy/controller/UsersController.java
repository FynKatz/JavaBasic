package com.huyy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huyy.pojo.Users;
import com.huyy.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;

	// 页面跳转
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}

	// 添加用户
	@RequestMapping("/addUser")
	public String addUser(Users users) {
		usersService.addUser(users);
		return "ok";
	}

	// 展示所有用户
	@RequestMapping("/getAllUsers")
	public String getAllUsers(Model model) {
		List<Users> list = usersService.getAllUsers();
		model.addAttribute("list", list);
		model.addAttribute("ag", "12");
		return "showUsers";
	}

	// 根据用户id 查询用户
	@RequestMapping("/getUsersById")
	public String findUserById(Integer id, Model model) {
		Users user = usersService.getUsersById(id);
		model.addAttribute("user", user);
		return "updateUsers";
	}

	// 更新用户
	@RequestMapping("/editUser")
	public String editUser(Users users) {
		usersService.updateUsersById(users);
		;
		return "ok";
	}

	// 删除用户
	@RequestMapping("/delUser")
	public String delUser(Integer id) {
		usersService.deleteUserById(id);
		return "redirect:/users/getAllUsers";
	}
}
