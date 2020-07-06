package com.huyy.service.impl.client;

import com.huyy.service.impl.WebServiceImpl;
import com.huyy.service.impl.WebServiceImplService;

/**
 * 调用WebService的客户端
 */
public class WSclient {

	public static void main(String[] args) {
		// 创建一个用于产生WebServiceImpl实例的工厂，WebServiceImplService类是wsimport工具生成的
		WebServiceImplService factory = new WebServiceImplService();
		// 通过工厂生成一个WebServiceImpl实例，WebServiceImpl是wsimport工具生成的
		WebServiceImpl wsImpl = factory.getWebServiceImplPort();
		// 调用WebService的sayHello方法
		String resResult = wsImpl.sayHello("新消息");
		System.out.println("调用WebService的sayHello方法返回的结果是：" + resResult);
		System.out.println("---------------------------------------------------");
	}
}