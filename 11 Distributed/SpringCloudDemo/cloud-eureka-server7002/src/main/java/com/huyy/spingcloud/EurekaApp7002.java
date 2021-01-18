package com.huyy.spingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yyhu
 * @create 2021-01-14-20:31
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApp7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp7002.class);
    }
}
