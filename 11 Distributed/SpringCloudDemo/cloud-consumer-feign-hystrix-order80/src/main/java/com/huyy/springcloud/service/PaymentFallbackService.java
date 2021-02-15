package com.huyy.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author yyhu
 * @create 2021-02-12-15:00
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService fall back-paymentInfo_TimeOut";
    }
}
