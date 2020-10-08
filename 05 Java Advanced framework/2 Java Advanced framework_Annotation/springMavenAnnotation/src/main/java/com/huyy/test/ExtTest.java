package com.huyy.test;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huyy.ext.ExtConfig;

public class ExtTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(ExtConfig.class);
		
		applicationContext.publishEvent(new ApplicationEvent(new String("自定义事件")) {});
		applicationContext.close();
	}
}
