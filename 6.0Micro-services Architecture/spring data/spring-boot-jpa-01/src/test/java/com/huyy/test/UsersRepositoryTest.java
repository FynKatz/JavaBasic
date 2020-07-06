package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyy.App;
import com.huyy.dao.UsersRepository;
import com.huyy.pojo.Users;



/**
 * 测试类
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UsersRepositoryTest {

	@Autowired
	private UsersRepository usersRepository;
	
	@Test
	public void testSave(){
		Users users = new Users();
		users.setAddress("北京市");
		users.setAge(31);
		users.setName("赵六");
		this.usersRepository.save(users);
	}
}