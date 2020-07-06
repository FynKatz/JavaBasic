package com.huyy.memento;

/** 
 * 备忘录
 * @author Administrator
 *
 */
public class Memento {
	private String state;
	//构造器
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public Memento(String state) {
		super();
		this.state = state;
	}
}
