package com.huyy.activemq.producer;

import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**topic模式生产者*/
@Component
public class Producer {

	@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;
    
    private static int count= 0;
       
    @Scheduled(fixedDelay=3000)
    public void sendTopic() {              //参数1：topic订阅主题名，参数2：发送消息
    	jmsMessagingTemplate.convertAndSend(this.topic, "hi,activeMQ( topic )，index=" + count++);
    }
}
