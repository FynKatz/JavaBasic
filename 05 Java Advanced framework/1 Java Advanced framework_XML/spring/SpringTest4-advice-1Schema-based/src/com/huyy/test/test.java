package com.huyy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		// 加载Spring配置
		ApplicationContext alc = new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo demo = alc.getBean("demo", Demo.class);
		demo.demo2();

	}
}
