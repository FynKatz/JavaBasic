package com.huyy.springcloud.mapper;

import com.huyy.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {

    Integer createPayment(@Param("serial") String serial);

    Payment getPaymentById(@Param("id") Long id);

}