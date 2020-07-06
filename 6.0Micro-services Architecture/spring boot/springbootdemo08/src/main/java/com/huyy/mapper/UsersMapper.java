package com.huyy.mapper;

import java.util.List;

import com.huyy.pojo.Users;

public interface UsersMapper {
	void insertUser(Users users);
	List<Users> selectAllUsers();
	Users selectUsersById(Integer id);
	void updateUsersById(Users users);
	void deleteUserById(Integer id);
}
