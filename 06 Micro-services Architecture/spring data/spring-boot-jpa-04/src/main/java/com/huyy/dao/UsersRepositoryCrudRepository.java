package com.huyy.dao;

import org.springframework.data.repository.CrudRepository;

import com.huyy.pojo.Users;

/**
 * CrudRepository接口
 *
 *
 */
public interface UsersRepositoryCrudRepository extends CrudRepository<Users, Integer> {

}
