package com.huyy.mall.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.huyy.mall.been.UserAddress;
import com.huyy.mall.service.OrderService;
import com.huyy.mall.service.UserService;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {

//	@Autowired
    @Reference
	UserService userService;
    
	@Override
	public List<UserAddress> initOrder(String userId) {
	    
		//查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		
		for (UserAddress userAddress : addressList) {
			System.out.println("查询的地址："+userAddress.getUserAddress());
		}
		return addressList;
	}
}
