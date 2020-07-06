package com.huyy.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.huyy.pojo.User;

public interface UserDao extends MongoRepository<User, Long>{

	public User findByUserName(String userName);
    public Page<User> findAll(Pageable var1);

}
