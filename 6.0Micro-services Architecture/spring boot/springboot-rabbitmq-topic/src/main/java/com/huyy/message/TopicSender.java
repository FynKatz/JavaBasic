package com.huyy.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hi, i am message.路由键为topic.1";
		System.out.println("Sender : " + context);
				//convertAndSend()方法的参数：交换机名，路由键名，消息内容
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context);//只发送到queueMessages队列
	}

	public void send1() {
		String context = "hi, i am message 1.路由键为topic.message";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);//发送到queueMessages队列和queueMessage队列
	}

	public void send2() {
		String context = "hi, i am messages 2.路由键为topic.messages";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);//只发送到queueMessages队列
	}

}