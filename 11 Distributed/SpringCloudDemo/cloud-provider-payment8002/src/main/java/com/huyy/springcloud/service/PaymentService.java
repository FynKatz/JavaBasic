package com.huyy.springcloud.service;

import com.huyy.springcloud.bean.Payment;

/**
 * @author yyhu
 * @create 2021-01-08-20:01
 **/
public interface PaymentService {

    int createPayment(String serial);

    Payment getPaymentById(Long id);

}
