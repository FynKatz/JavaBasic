package com.huyy.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyy.App;
import com.huyy.dao.UsersRepositoryByName;
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
	private UsersRepositoryByName usersRepositoryByName;
	
	/**
	 * Repository--方法名称命名测试
	 */
	@Test
	public void testFindByName(){
		List<Users> list = this.usersRepositoryByName.findByName("张三");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * Repository--方法名称命名测试
	 */
	@Test
	public void testFindByNameAndAge(){
		List<Users> list = this.usersRepositoryByName.findByNameAndAge("张三", 20);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * Repository--方法名称命名测试
	 */
	@Test
	public void testFindByNameLike(){
		List<Users> list = this.usersRepositoryByName.findByNameLike("王%");
		for (Users users : list) {
			System.out.println(users);
		}
	}
}

