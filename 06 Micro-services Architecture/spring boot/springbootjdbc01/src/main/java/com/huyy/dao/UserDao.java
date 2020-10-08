package com.huyy.dao;

import java.util.List;

import com.huyy.pojo.User;

public interface UserDao {
	
	int save(User user);//新增

	int update(User user);//更新

	int delete(long id);//删除

	List<User> findALL();//查找全部

	User findById(long id);//按ID查找
}
