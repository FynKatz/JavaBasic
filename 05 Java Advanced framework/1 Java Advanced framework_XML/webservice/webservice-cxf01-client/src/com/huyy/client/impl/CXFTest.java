package com.huyy.client.impl;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.huyy.client.StudentScoreService;

public class CXFTest {
	public static void main(String[] args) {
		// 1.创建JaxWsProxyFactoryBean的对象，用于接收服务
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		// 2.设置服务的发布接口，使用本地的代理接口
		factoryBean.setServiceClass(StudentScoreService.class);
		// 3.设置服务的发布地址，表示去哪里获取服务
		String address = "http://localhost:8089/score";
		factoryBean.setAddress(address);
		// 4.通过create方法返回接口代理实例
		StudentScoreService service = (StudentScoreService) factoryBean.create();
		System.out.println(service.getScore("小王"));
	}

}
