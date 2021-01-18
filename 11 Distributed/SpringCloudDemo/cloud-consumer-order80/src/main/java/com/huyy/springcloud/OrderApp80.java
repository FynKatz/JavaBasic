package com.huyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yyhu
 * @create 2021-01-11-20:46
 **/
@SpringBootApplication
@EnableEurekaClient
public class OrderApp80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp80.class);
    }
}
