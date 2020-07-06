package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.huyy.dao.UsersDao;
import com.huyy.pojo.Roles;
import com.huyy.pojo.Users;


/**
 * 一对一关联关系测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OneToManyTest {

	@Autowired
	private UsersDao usersDao;

	/**
	 * 添加用户同时添加角色
	 */
	@Test
	public void test1() {
		// 创建角色
		Roles roles = new Roles();
		roles.setRolename("管理员");
		// 创建用户
		Users users = new Users();
		users.setUserage(30);
		users.setUsername("小王");
		// 建立关系
		roles.getUsers().add(users);
		users.setRoles(roles);
		// 保存数据
		this.usersDao.save(users);
	}

	/**
	 * 根据用户ID 查询用户信息，同时查询角色
	 */
	@Test
	public void test2() {
		Users users = this.usersDao.findOne(19);
		System.out.println("用户姓名：" + users.getUsername());
		Roles roles = users.getRoles();
		System.out.println(roles);
	}
}
