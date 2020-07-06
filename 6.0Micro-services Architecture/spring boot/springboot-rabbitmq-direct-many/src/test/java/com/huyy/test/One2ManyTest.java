package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.huyy.message.NeoSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class One2ManyTest {
	
	@Autowired
	private NeoSender neoSender;

	@Test
	public void oneToMany() throws Exception {
		for (int i=0;i<10;i++){
			neoSender.send(i);
		}
		Thread.sleep(10000l);
	}

}