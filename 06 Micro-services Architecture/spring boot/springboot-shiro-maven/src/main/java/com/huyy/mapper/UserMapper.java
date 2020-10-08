package com.huyy.mapper;

import org.apache.ibatis.annotations.Param;

import com.huyy.bean.User;

public interface UserMapper {
	
	public User getUserByName(@Param("name")String name);
}
