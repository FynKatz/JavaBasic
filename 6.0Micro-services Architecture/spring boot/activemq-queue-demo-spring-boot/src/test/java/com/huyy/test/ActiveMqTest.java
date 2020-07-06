package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyy.activemq.ActiveMqApplication;
import com.huyy.activemq.producer.Producer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ActiveMqApplication.class)
public class ActiveMqTest {

	@Autowired
    private Producer producer;
    
    @Test
    public void sendQueue() {
    	producer.sendQueue();
    }
}
