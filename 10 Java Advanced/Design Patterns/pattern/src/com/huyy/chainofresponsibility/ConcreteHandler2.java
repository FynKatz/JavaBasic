package com.huyy.chainofresponsibility;

public class ConcreteHandler2 extends Handler{

	//构造器必须实现
	public ConcreteHandler2(String name) {
		super(name);
	}

	@Override
	public void handleRequest(String request) {
		if ("two".equals(request)) {
			System.out.println(this.name +"处理了。");
		}else {
			if (this.next != null) {
				System.out.println(this.name + "交给了"+this.next.getName());
				this.next.handleRequest(request);				
			}else {
				System.out.println("没有人处理了");
			}
			
		}
		
	}

	
}
