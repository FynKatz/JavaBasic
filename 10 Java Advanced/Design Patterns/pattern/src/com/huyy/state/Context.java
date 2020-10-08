package com.huyy.state;

/**
 * 环境类
 * @author Administrator
 *
 */
public class Context {
	State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}
