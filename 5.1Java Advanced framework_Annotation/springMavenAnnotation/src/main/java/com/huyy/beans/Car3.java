package com.huyy.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Car3 implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	//构造器
	public Car3() {
		System.out.println("Car3 constructor");
	}
	//在bean创建完成并且属性赋值完成后，来执行初始化方法
	@PostConstruct 
	public void init() {
		System.out.println("Car3 init");
	}
	//在容器销毁bean之前通知我们进行清理工作
	@PreDestroy
	public void destroy() {
		System.out.println("Car3 destroy");
	}
	
	//注入IOC容器
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;		
	}	
}
 