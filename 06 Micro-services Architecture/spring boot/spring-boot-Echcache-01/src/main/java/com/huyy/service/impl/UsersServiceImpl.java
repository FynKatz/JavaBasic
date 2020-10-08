package com.huyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huyy.dao.UsersRepository;
import com.huyy.pojo.Users;
import com.huyy.service.UsersService;

/**
 * UsersService接口实现类
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	@Cacheable(value="users")
	public List<Users> findUserAll() {
		return this.usersRepository.findAll();
	}

	@Override
	//@Cacheable:对当前查询的对象做缓存处理
	@Cacheable(value="users",key="#id")
	public Users findUserById(Integer id) {
		return this.usersRepository.findOne(id);
	}

	@Override
	public Page<Users> findUserByPage(Pageable pageable) {
		return this.usersRepository.findAll(pageable);
	}

	@Override
	//@CacheEvict(value="users",allEntries=true) 清除缓存中以users策略缓存的对象
	@CacheEvict(value="users",allEntries=true)
	public void saveUsers(Users users) {
		this.usersRepository.save(users);
	}
}
