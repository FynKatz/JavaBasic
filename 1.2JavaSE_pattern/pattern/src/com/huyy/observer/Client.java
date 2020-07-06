package com.huyy.observer;

public class Client {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		
		//注册
		Observer obs1 = new ConcreteObserver();
		Observer obs2 = new ConcreteObserver();
		subject.add(obs1);
		subject.add(obs2);
		
		//通知
		subject.setState("new");
		
	}
}
