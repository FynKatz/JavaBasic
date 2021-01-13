package com.huyy.springcloud.service.impl;

import com.huyy.springcloud.bean.Payment;
import com.huyy.springcloud.mapper.PaymentMapper;
import com.huyy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yyhu
 * @create 2021-01-08-20:02
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentMapper paymentMapper;

    @Override
    public int createPayment(String serial) {
        return paymentMapper.createPayment(serial);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

}
