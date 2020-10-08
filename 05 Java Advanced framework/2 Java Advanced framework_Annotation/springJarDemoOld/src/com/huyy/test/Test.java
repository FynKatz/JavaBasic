package com.huyy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huyy.beans.People;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		People people = ac.getBean("people", People.class);//获取bean
//		System.out.println(people);
	}
}
 