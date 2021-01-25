package com.huyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther yyhu
 * 2021-01-25 19:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApp8006
{
    public static void main(String[] args) {
            SpringApplication.run(PaymentApp8006.class, args);
    }
}
