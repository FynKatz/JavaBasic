package com.huyy.activemq.producer;

import javax.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**queue的生产者*/
@Component
public class Producer {

	@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
    private Queue queue;
    
    @Scheduled(fixedDelay=3000)
    public void sendQueue() {				//参数1：queue队列名，参数2：发送消息
    	jmsMessagingTemplate.convertAndSend(this.queue,"hi.activeMQ");
    } 
}
