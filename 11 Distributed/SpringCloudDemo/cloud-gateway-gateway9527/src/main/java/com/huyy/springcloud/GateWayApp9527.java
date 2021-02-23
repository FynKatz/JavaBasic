package com.huyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GateWayApp9527 {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApp9527.class, args);
    }
}
