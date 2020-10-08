package com.huyy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huyy.bean.User;
import com.huyy.mapper.UserMapper;
import com.huyy.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
		
	@Override
	public User getUserByName(String name) {
		User user = userMapper.getUserByName(name);
		return user;
	}
	
}
