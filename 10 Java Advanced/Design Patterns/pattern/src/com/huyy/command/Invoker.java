package com.huyy.command;

/** 调用者
 * @author Administrator
 *
 */
public class Invoker {
	
	private Command command;
	//也可以通过容器List<Command>容纳很多命令对象，进行批处理。数据库底层的事务管理就是类似的结构！

	//构造器
	public Invoker(Command command) {
		super();
		this.command = command;
	}
	
	//业务方法 ，用于调用命令类的方法
	public void call(){
		System.out.println("调用者执行命令command...");
		command.execute();
	}
}
