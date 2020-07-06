package com.huyy.publish;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.huyy.service.StudentScoreService;
import com.huyy.service.impl.StudentScoreServiceImpl;

public class PublishStudentService {
	public static void main(String[] args) {
		
		// CXF发布方式
		JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
		String address = "http://localhost:8089/score";
		Object implementor = new StudentScoreServiceImpl();
		// 设置服务的地址
		factoryBean.setAddress(address);
		// 设置服务的实现类
		factoryBean.setServiceBean(implementor);
		// 设置接口
		factoryBean.setServiceClass(StudentScoreService.class);
		// 发布
		factoryBean.create();
	}
}
