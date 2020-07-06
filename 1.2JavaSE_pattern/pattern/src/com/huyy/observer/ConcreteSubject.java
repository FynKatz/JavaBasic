package com.huyy.observer;

public class ConcreteSubject extends Subject{
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		this.notifyObserver();//状态改变后通知其他观察者
	}
	
}
