package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.huyy.message.NeoSender;
import com.huyy.message.NeoSender2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Many2ManyTest {
	
	@Autowired
	private NeoSender neoSender;
	@Autowired
	private NeoSender2 neoSender2;

	@Test
	public void oneToMany() throws Exception {
		for (int i=0;i<10;i++){
			neoSender.send(i);
		}
		Thread.sleep(10000l);
	}
	
	@Test
	public void manyToMany() throws Exception {
		for (int i=0;i<10;i++){
			neoSender.send(i);
			neoSender2.send(i);
		}
		Thread.sleep(10000l);
	}

}