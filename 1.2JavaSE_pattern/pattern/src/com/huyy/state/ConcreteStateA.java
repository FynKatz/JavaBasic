package com.huyy.state;

/** 实现状态A
 * @author Administrator
 *
 */
public class ConcreteStateA implements State{

	@Override
	public void handler() {
		System.out.println("状态A，可以做某些处理");		
	}

}
