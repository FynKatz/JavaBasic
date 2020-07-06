package com.huyy.activemq.config;

import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class ActiveMqConfig {
	
	/**
	 * 注入 Topic对象
	 * @return
	 */
	@Bean
	public Topic topic() {
		return new ActiveMQTopic("abc.topic");
	}	
}
