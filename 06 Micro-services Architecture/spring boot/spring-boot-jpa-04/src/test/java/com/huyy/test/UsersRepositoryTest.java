package com.huyy.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyy.App;
import com.huyy.dao.UsersRepositoryCrudRepository;
import com.huyy.pojo.Users;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class UsersRepositoryTest {

	@Autowired
	private UsersRepositoryCrudRepository usersRepositoryCrudRepository;

	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositorySave() {
		Users user = new Users();
		user.setAddress("天津");
		user.setAge(32);
		user.setName("王晓丽");
		this.usersRepositoryCrudRepository.save(user);
	}

	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositoryUpdate() {
		Users user = new Users();
		user.setId(4);
		user.setAddress("南京");
		user.setAge(40);
		user.setName("王晓丽");
		this.usersRepositoryCrudRepository.save(user);
	}

	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositoryFindOne() {
		Users users = this.usersRepositoryCrudRepository.findOne(4);
		System.out.println(users);
	}

	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositoryFindAll() {
		List<Users> list = (List<Users>) this.usersRepositoryCrudRepository.findAll();
		for (Users users : list) {
			System.out.println(users);
		}
	}

	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositoryDeleteById() {
		this.usersRepositoryCrudRepository.delete(4);

	}
}
