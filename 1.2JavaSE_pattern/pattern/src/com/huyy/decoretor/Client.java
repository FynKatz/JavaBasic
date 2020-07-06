package com.huyy.decoretor;

public class Client {
	public static void main(String[] args) {
		//真实的具体构件角色
		Component component = new ConcreteComponent();
		component.operation();
		
		System.out.println("");
		
		//具体的装饰角色1
		Component decorator = new ConcreteDecorator(component);//传入具体构件角色
		decorator.operation();
		
		System.out.println();
		
		//具体装饰角色2
		Component decorator2 = new ConcreteDecorator2(decorator);//传入装饰角色1
		decorator2.operation();
	}
}
