package com.huyy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huyy.mapper.UsersMapper;
import com.huyy.pojo.Users;
import com.huyy.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Resource
	private UsersMapper usersMapper;
		
	@Override
	public List<Users> show() {
		return usersMapper.selectAll();
	}

}
