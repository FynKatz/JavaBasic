package com.huyy.chainofresponsibility;

abstract class Handler {
	/**必须为protected，不然子类继承不到。*/
	protected String name;//节点姓名。
	protected Handler next;//下一节点
	//构造器
	public Handler(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Handler getNext() {
		return next;
	}
	public void setNext(Handler next) {
		this.next = next;
	}
	
	/**
	 * 处理请求的核心的业务方法（抽象方法）
	 * @param request
	 */
	public abstract void handleRequest(String request);	
}
