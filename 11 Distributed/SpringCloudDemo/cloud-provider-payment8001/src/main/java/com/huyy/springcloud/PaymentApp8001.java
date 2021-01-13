package com.huyy.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yyhu
 * @create 2021-01-08-17:30
 **/
@SpringBootApplication
@MapperScan("com.huyy.springcloud.mapper")
public class PaymentApp8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApp8001.class,args);
    }
}
