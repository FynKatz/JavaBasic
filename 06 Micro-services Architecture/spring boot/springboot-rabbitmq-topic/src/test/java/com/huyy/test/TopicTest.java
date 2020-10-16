package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.huyy.message.TopicSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {

	@Autowired
	private TopicSender sender;

	//发送者发送的路由键为topic.1
	@Test
	public void topic() throws Exception {
		sender.send();
		Thread.sleep(1000l);
	}

	//发送者发送的路由键为topic.message
	@Test
	public void topic1() throws Exception {
		sender.send1();
		Thread.sleep(1000l);
	}

	//发送者发送的路由键为topic.messages
	@Test
	public void topic2() throws Exception {
		sender.send2();
		Thread.sleep(1000l);
	}
}