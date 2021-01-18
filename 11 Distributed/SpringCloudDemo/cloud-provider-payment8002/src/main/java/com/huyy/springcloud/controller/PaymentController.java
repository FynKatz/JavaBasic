package com.huyy.springcloud.controller;

import com.huyy.springcloud.bean.CommonResult;
import com.huyy.springcloud.bean.Payment;
import com.huyy.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yyhu
 * @create 2021-01-08-20:05
 **/
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody String serial){
        int result = paymentService.createPayment(serial);
        if (result>0){  //成功
            return new CommonResult(200,"插入数据库成功>>serverPort:"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败>>serverPort:"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null){  //说明有数据，能查询成功
            return new CommonResult(200,"查询成功>>serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id+">>serverPort:"+serverPort,null);
        }
    }

}
