package com.huyy.service.impl;

import com.huyy.service.WebService;

@javax.jws.WebService
public class WebServiceImpl implements WebService{

	@Override
	public String sayHello(String name) {
		System.out.println("发布消息成功。");
		String str=name+"message 1";
		return str;
	}

}
