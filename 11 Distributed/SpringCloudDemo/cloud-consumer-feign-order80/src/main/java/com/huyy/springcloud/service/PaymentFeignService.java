package com.huyy.springcloud.service;

import com.huyy.springcloud.bean.CommonResult;
import com.huyy.springcloud.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther yyhu
 * @create 2021-01-31 16:32
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //指定 调用微服务的名称
public interface PaymentFeignService{

    //调用8001的接口
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
