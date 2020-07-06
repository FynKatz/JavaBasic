package com.huyy.command;

/** 客户端
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		Command command = new ConcreteCommand(new Receiver());
		Invoker invoker = new Invoker(command);
		
		invoker.call();
	}
}
