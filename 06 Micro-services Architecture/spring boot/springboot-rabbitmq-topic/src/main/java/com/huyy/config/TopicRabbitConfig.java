package com.huyy.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

	// 1.新建两种队列
	final static String message = "topic.message";
	final static String messages = "topic.messages";

	@Bean
	public Queue queueMessage() {
		return new Queue(TopicRabbitConfig.message);
	}

	@Bean
	public Queue queueMessages() {
		return new Queue(TopicRabbitConfig.messages);
	}

	// 2.新建一个交换机，名为topicExchange
	@Bean
	TopicExchange exchange() {
		return new TopicExchange("topicExchange");
	}

	// 3.队列绑定交换机
	/**
	 * BindingBuilder.bind(queue).to(exchange).with(routing_key);
	 * 将一个queue绑定到exchange并用routing_key作为绑定键
	 */
	@Bean
	Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
		// 将queueMessage队列绑定到topicExchange交换机，并用"topic.message"作为绑定键
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}

	@Bean
	Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
		// 将queueMessages队列绑定到topicExchange交换机，并用"topic.#"作为绑定键
		return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
	}
}
