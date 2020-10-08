package com.huyy.activemq.receive;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**topic模式消费者*/
@Component
public class TopicReceiver {

	@JmsListener(destination = "abc.topic")
	public void receiveTopic1 (String message) {
		System.out.println("Topic Consumer1:" + message);
	}
	
	@JmsListener(destination = "abc.topic")
	public void receiveTopic2 (String message) {
		System.out.println("Topic Consumer2:" + message);
	}
}
