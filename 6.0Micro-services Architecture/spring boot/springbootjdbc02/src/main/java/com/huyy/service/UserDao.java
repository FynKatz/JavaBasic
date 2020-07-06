package com.huyy.service;

import java.util.List;

import com.huyy.pojo.User;

import net.sf.json.JSONObject;

public interface UserDao {
	
	int save(User user);//新增

	int update(User user);//更新

	int delete(long id);//删除

	List<User> findALL();//查找全部

	User findById(long id);//按ID查找
	
	List<User> getUserById(int id);

    String saveUser(JSONObject jo);//存储数据

    List<User> getUserByIdName(int id, String name);

    List<User> getUserByIdName2(String id, String name);

    
}
