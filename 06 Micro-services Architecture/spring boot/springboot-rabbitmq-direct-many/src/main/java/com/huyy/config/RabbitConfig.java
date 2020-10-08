package com.huyy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitConfig {
    
    @Bean
    public Queue neoQueue() {
        return new Queue("neo");//新建一个队列
    }

}