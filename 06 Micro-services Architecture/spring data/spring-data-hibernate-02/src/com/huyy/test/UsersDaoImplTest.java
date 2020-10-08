package com.huyy.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;//手动引入
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.huyy.dao.UsersDao;
import com.huyy.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UsersDaoImplTest {
	@Autowired
	private UsersDao usersDao;

	/**
	 * 添加用户
	 */
	@Test
	@Transactional // 在测试类对于事务提交方式默认的是回滚。
	@Rollback(false) // 取消自动回滚
	public void testInsertUsers() {
		Users users = new Users();
		users.setUserage(15);
		users.setUsername("明明");
		this.usersDao.insertUsers(users);
	}

	/**
	 * 更新用户
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateUsers() {
		Users users = new Users();
		users.setUserid(3);
		users.setUserage(22);
		users.setUsername("婷婷");
		this.usersDao.updateUsers(users);
	}

	/**
	 * 根据userid 查询用户
	 */
	@Test
	public void testSelectUsersById() {
		Users users = this.usersDao.selectUsersById(3);
		System.out.println(users);//需要在User是中添加toString（）方法
	}

	/**
	 * 删除用户
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteUsers() {
		Users users = new Users();
		users.setUserid(3);
		this.usersDao.deleteUsers(users);
	}
	
	/**
	 * HQL 测试
	 */
	@Test
	@Transactional
	public void testSelectUserByName() {
		List<Users> list = this.usersDao.selectUserByName("明明");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * SQL 测试
	 */
	@Test
	@Transactional
	public void testSelectUserByNameUseSQL() {
		List<Users> list = this.usersDao.selectUserByNameUseSQL("明明");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * Criteria 测试
	 */
	@Test
	@Transactional
	public void testSelectUserByNameUseCriteria() {
		List<Users> list = this.usersDao.selectUserByNameUseCriteria("明明");
		for (Users users : list) {
			System.out.println(users);
		}
	}
}