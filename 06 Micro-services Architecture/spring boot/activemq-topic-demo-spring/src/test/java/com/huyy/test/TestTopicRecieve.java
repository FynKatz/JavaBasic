package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**测试topic模式-消费者*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-consumer-topic.xml")
public class TestTopicRecieve {
    @Test
    public void testQueueRecieve(){
        try {
            //让连接不关闭
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
