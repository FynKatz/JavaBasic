package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.huyy.message.FanoutSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutTest {

	@Autowired
	private FanoutSender sender;

	//发送者发送的路由键为topic.1
	@Test
	public void fanoutSender() throws Exception {
		sender.send();
		Thread.sleep(1000l);
	}


}