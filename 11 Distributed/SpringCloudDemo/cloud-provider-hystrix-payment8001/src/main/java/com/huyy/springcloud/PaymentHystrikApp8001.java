package com.huyy.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author yyhu
 * @create 2021-02-04-20:27
 **/
@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrikApp8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrikApp8001.class, args);
    }

}
