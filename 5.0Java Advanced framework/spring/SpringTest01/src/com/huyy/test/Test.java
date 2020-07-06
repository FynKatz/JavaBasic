package com.huyy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huyy.pojo.People;
import com.huyy.pojo.PeopleStaticFactory;

public class Test {
	public static void main(String[] args) {
		// 工厂模式
		// PeopleFactory factory = new PeopleFactory();
		// People people = factory.newInstance();

		// Spring来处理工厂模式
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		People people = ac.getBean("peo2", People.class);
		System.out.println(people);

		// 静态工厂模式
//		People people2 = PeopleStaticFactory.newInstance();
//		System.out.println(people2);
	}
}
