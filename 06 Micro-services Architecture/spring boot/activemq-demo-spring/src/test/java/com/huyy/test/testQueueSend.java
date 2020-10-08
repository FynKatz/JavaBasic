package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyy.producer.QueueProducer;

/**
 * 测试消费者
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-producer.xml")
public class testQueueSend {
    @Autowired
    private QueueProducer queueProducer;
    @Test
    public void testQueueSend(){
        queueProducer.sendTextMessage("hello hi");
    }
}
