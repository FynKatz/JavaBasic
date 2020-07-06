package com.huyy.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.huyy.pojo.User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {

	@Autowired
    private UserDao userDao;

	@Test
	public void testSave() {
		User user =new User("neo","123456",30);
		userDao.save(user);
	}

	@Test
	public void testUpdate() {
		User user =new User("neo","123456",18);
		user.setId(1L);
		userDao.update(user);
	}

	@Test
	public void testDetele() {
		userDao.delete(1L);
	}

	@Test
	public void testQueryOne()  {
		User user=userDao.findById(2L);
		System.out.println("user == "+user.toString());
	}

	@Test
	public void testQueryAll()  {
		List<User> users=userDao.findALL();
		for (User user:users){
			System.out.println("user == "+user.toString());
		}
	}

}
