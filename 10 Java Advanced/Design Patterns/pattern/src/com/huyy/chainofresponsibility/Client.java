package com.huyy.chainofresponsibility;

public class Client {
	public static void main(String[] args) {
		
		Handler handler1 = new ConcreteHandler1("lee");
		Handler handler2 = new ConcreteHandler2("zhang");
		handler1.setNext(handler2);//设置责任链
		
		handler1.handleRequest("two");
		
		System.out.println();
		
		handler1.handleRequest("three");
		
		
	}
}
