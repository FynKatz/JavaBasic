package com.huyy.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yyhu
 * @create 2021-01-08-17:30
 **/
@SpringBootApplication
@MapperScan("com.huyy.springcloud.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentApp8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApp8001.class,args);
    }
}
