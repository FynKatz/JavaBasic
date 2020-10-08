package com.huyy.factory.simplefactory;

/**
 * 测试在没有工厂模式的情况下
 */
public class Client01 {   //调用者
	
	public static void main(String[] args) {
		Car c1 = CarFactory.createAudi();
		Car c2 = CarFactory.createByd();
		
		c1.run();
		c2.run();
		
	}
}
