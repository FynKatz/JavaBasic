package com.huyy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.huyy.beans.People;
import com.huyy.config.SpringConfig;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);		
//		//1.用类型获取bean
//		People people1 = ac.getBean(People.class);
//		System.out.println(people1);
		
//		Environment environment = ac.getEnvironment();//获取系统参数
//		String systemName = environment.getProperty("os.name");//获取操作系统名称
//		System.out.println(systemName);
		//获取该bean的名称（id）
//		String[] names = ac.getBeanNamesForType(People.class);
		String[] names = ac.getBeanDefinitionNames();//查找全部的bean
		for (String name : names) {
			System.out.println(name);
		}
		Object object = ac.getBean("colorFactoryBean");
		System.out.println("colorFactoryBean的类型"+object.getClass());
		//测试下单例（我们设定的是非单例）
		Object object2 = ac.getBean("colorFactoryBean");
		System.out.println(object==object2);
		
		Object object3 = ac.getBean("colorFactoryBean");
		System.out.println(object3);
		Object object4 = ac.getBean("&colorFactoryBean");
		System.out.println(object4);
		
//		//2.使用名称获取bean
//		People people2 = (People) ac.getBean("people");
//		People people3 = (People) ac.getBean("people");
//		System.out.println(people2 == people3);
		
		
		
	}
}
 