package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyy.App;
import com.huyy.service.impl.UserServiceImpl;

/**
 * SpringBoot 测试类
 * 
 * 参数说明：
 * @RunWith:启动器 SpringJUnit4ClassRunner.class：让junit 与spring 环境进行整合
 * @SpringBootTest(classes={App.class}) 1）当前类为springBoot 的测试类
 *                                      2）加载SpringBoot 启动类。启动 springBoot
 *
 * junit 与spring整合 @Contextconfiguartion("classpath:applicationContext.xml")
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { App.class })
public class UserServiceTest {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Test
	public void testAddUser() {
		userServiceImpl.addUser();
	}
}