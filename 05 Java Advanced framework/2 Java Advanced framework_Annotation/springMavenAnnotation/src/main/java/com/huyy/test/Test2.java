package com.huyy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.huyy.beans.People;
import com.huyy.config.ConfigOfLifeCycle;
import com.huyy.config.SpringConfig;

public class Test2 {
	public static void main(String[] args) {
		//创建容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConfigOfLifeCycle.class);		
		System.out.println("容器创建完成");
		
		//关闭容器
		ac.close();
		
		
	}
}
 