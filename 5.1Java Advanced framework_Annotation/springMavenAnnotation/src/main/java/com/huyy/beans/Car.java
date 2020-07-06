package com.huyy.beans; 

public class Car {

	//构造器
	public Car() {
		System.out.println("Car constructor");
	}
	//（自定义）初始化方法
	public void init() {
		System.out.println("Car init");
	}
	//（自定义）销毁方法
	public void destroy() {
		System.out.println("Car destroy");
	}	
}
 