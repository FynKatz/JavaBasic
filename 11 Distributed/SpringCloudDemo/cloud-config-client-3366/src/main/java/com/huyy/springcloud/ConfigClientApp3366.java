package com.huyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConfigClientApp3366 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp3366.class, args);
    }
}
