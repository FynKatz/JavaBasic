package com.huyy.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hi, fanout msg ";
		System.out.println("Sender : " + context);
				//convertAndSend()方法的参数：交换机名，路由键名，消息内容
		this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
	}

}