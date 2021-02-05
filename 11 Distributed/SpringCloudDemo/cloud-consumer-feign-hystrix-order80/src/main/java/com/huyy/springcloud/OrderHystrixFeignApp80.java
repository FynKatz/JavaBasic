package com.huyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yyhu
 * @create 2021-02-05-20:55
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixFeignApp80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixFeignApp80.class, args);
    }
}
