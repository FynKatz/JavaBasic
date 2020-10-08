package com.huyy.observer;

public class ConcreteObserver implements Observer{

	@Override
	public void response() {
		System.out.println("观察者收到消息");		
	}

}
