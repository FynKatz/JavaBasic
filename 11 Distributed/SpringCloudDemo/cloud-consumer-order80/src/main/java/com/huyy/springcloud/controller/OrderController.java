package com.huyy.springcloud.controller;

import com.huyy.springcloud.bean.CommonResult;
import com.huyy.springcloud.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yyhu
 * @create 2021-01-11-21:03
 **/
@RestController
@Slf4j
public class OrderController{

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(String serial) {
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "/payment/create", serial, CommonResult.class);
        return commonResult;
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return commonResult;
    }

}
