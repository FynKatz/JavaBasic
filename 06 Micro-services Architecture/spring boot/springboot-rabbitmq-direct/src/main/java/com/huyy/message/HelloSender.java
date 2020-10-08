package com.huyy.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	//发送和接收消息的操作模板类AmqpTemplate，包含一些基本的操作功能

	public void send() {
		String context = "hello " + new Date();
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hello", context);
	}
}