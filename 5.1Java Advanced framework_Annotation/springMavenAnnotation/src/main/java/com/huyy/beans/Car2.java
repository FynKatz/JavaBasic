package com.huyy.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Car2 implements InitializingBean,DisposableBean{

	//构造器
	public Car2() {
		System.out.println("Car2 constructor");
	}

	//自定义初始化
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Car2 init");		
	}
	//自定义销毁
	@Override
	public void destroy() throws Exception {
		System.out.println("Car2 destroy");
	}
}
 