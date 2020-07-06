package com.huyy.mall.service;

import java.util.List;

import com.huyy.mall.been.UserAddress;

public interface OrderService {
	
	/**
	 * 初始化订单
	 * @param userId
	 */
	public List<UserAddress> initOrder(String userId);

}
