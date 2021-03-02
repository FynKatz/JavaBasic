package com.huyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientApp3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientApp3377.class, args);
    }
}
