package com.huyy.mediator;

public class ConcreteColleague2 implements Colleague {
	
	protected Mediator mediator;//存储中介引用
	
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;		
	}

	@Override
	public void send() {
		System.out.println("具体同事类2发出请求。");
		mediator.relay(this);//中介转发请求
	}

	@Override
	public void receive() {
		System.out.println("具体同事类2收到请求。");
	}

	
}
