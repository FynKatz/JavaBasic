package com.huyy.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.huyy.beans.Color;
import com.huyy.config.ConfigOfPropertyValue;

public class Test3 {
	public static void main(String[] args) {
		//创建容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConfigOfPropertyValue.class);		
		System.out.println("容器创建完成");
		
		//打印Car对象
		Color color = (Color)ac.getBean("color");
		System.out.println(color);
		
		ConfigurableEnvironment environment = ac.getEnvironment();
		String property = environment.getProperty("name");
		System.out.println(property);
		
		//关闭容器
		ac.close();		
	}
}
 