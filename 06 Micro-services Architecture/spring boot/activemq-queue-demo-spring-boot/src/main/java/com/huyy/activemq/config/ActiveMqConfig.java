package com.huyy.activemq.config;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
@EnableJms
public class ActiveMqConfig {
	
	/**注入Queue对象**/
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("boot.queue");  //queue队列名称
	}
	
	
	
}
