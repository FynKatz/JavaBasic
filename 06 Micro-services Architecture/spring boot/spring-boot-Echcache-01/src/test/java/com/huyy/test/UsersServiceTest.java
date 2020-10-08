package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyy.App;
import com.huyy.pojo.Users;
import com.huyy.service.UsersService;

/**
 * UsersService测试
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UsersServiceTest {

	@Autowired
	private UsersService usersService;
	
	@Test
	public void testFindUserById(){
		//第一次查询
		System.out.println(this.usersService.findUserById(1));
		
		//第二次查询
		System.out.println(this.usersService.findUserById(1));
	}
	
	@Test
	public void testFindAll(){
		//第一次查询
		System.out.println(this.usersService.findUserAll().size());
		
		Users users = new Users();
		users.setAddress("南京");
		users.setAge(43);
		users.setName("朱七");
		this.usersService.saveUsers(users);
		
		//第二次查询
		System.out.println(this.usersService.findUserAll().size());
	}
}
