package com.huyy.memento;

/**
 * 发起人
 * @author Administrator
 *
 */
public class Originator {

	private String state;
	//构造器
	public Originator(String state) {
		super();
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	//创建备份
	public Memento createMemento(){
		return new Memento(state);
	}
	//恢复备份
	public void recovery(Memento memt){
		this.state = memt.getState();
	}	
}
