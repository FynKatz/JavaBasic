package com.huyy.dao;

import java.util.List;

import com.huyy.pojo.Users;

public interface UsersDao {
	
	public void insertUsers(Users users);
	
	public void updateUsers(Users users);
	
	public void deleteUsers(Users users);
	
	public Users selectUsersById(Integer userid);
	
	public List<Users> selectUserByName(String username);
	
	public List<Users> selectUserByNameUseSQL(String username);
	
	public List<Users> selectUserByNameUseCriteria(String username);
}
