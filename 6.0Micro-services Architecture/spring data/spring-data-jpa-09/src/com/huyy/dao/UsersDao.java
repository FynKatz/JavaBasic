package com.huyy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huyy.pojo.Users;

/**
* 映射关系操作
*/
public interface UsersDao extends JpaRepository<Users,Integer>,JpaSpecificationExecutor<Users>{
	
}
