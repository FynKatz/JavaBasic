package com.huyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yyhu
 * @create 2021-01-11-20:46
 **/
@SpringBootApplication
@EnableFeignClients
public class OrderFeignApp80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApp80.class);
    }
}
