package com.huyy.mediator;

public class Client {
	public static void main(String[] args) {
		Mediator mediator = new ConcreteMediator();//中介者对象
		
		Colleague c1 = new ConcreteColleague1();
		Colleague c2 = new ConcreteColleague2();
		mediator.register(c1);//中介者注册同事，同时也设定该同事的中介者是该mediator对象
		mediator.register(c2);//中介者注册同事，同时也设定该同事的中介者是该mediator对象
		
		c1.send();
		System.out.println();
		c2.send();				
	}
}
