package com.huyy.state;

/** 实现状态B
 * @author Administrator
 *
 */
public class ConcreteStateB implements State{

	@Override
	public void handler() {
		System.out.println("状态B，可以做某些处理");		
	}

}
