package com.huyy.state;

/**
 * 客户端
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		Context ctx = new Context();
		
		State stateA = new ConcreteStateA();
		ctx.setState(stateA);
		stateA.handler();
		
	}
}
