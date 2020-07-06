package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyy.producer.TopicProducer;

/**测试topic模式-生产者 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-producer.xml")
public class testTopicSend {
    @Autowired
    private TopicProducer topicProducer;


    @Test
    public void testTopicSend() {
        topicProducer.sendTextMessage("topic message one");
    }
}
