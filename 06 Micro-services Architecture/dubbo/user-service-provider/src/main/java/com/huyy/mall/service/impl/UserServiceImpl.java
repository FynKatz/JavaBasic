package com.huyy.mall.service.impl;

import java.util.Arrays;
import java.util.List;

import com.huyy.mall.been.UserAddress;
import com.huyy.mall.service.UserService;


public class UserServiceImpl implements UserService {

	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		
		UserAddress address1 = new UserAddress(1, "北京市", "1", "张三", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市", "1", "李四", "010-56253825", "N");
		
		if (userId.equals("1")) {
		    return Arrays.asList(address1);
        }else {
            return Arrays.asList(address2);
        }
	}

}
