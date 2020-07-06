package com.huyy.activemq.receive;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**queue消费者**/
@Component
public class QueueReceiver {
	
	//queue模式下，只有一个消费者在消费
	@JmsListener(destination = "boot.queue")
	public void receiveQueue1 (String message) {
		System.out.println("Queue Consumer1:" + message);
	}
	
	@JmsListener(destination = "boot.queue")
	public void receiveQueue2 (String message) {
		System.out.println("Queue Consumer2:" + message);
	}
}
