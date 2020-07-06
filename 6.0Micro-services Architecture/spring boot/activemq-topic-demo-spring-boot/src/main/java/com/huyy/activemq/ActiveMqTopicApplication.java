package com.huyy.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ActiveMqTopicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveMqTopicApplication.class, args);
	}
}
