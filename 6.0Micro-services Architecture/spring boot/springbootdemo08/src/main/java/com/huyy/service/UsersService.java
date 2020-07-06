package com.huyy.service;

import java.util.List;

import com.huyy.pojo.Users;

public interface UsersService {
	public void addUser(Users users);//添加新用户
	public List<Users> getAllUsers();//查询所有用户
	public Users getUsersById(Integer id);
	public void updateUsersById(Users users);
	public void deleteUserById(Integer id);
}
