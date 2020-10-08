package com.huyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huyy.mapper.UsersMapper;
import com.huyy.pojo.Users;
import com.huyy.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public void addUser(Users users) {
		usersMapper.insertUser(users);
	}

	@Override
	public List<Users> getAllUsers() {
		return usersMapper.selectAllUsers();
	}

	@Override
	public Users getUsersById(Integer id) {
		return usersMapper.selectUsersById(id);
	}

	@Override
	public void updateUsersById(Users users) {
		usersMapper.updateUsersById(users);		
	}

	@Override
	public void deleteUserById(Integer id) {
		usersMapper.deleteUserById(id);
	}
}
