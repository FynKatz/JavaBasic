package com.huyy.command;

/** 实现命令类
 * @author Administrator
 *
 */
public class ConcreteCommand implements Command {
	
	private Receiver receiver;//命令的真正的执行者
	//构造器
	public ConcreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.action();//命令真正执行前或后，执行相关的处理！
	}

}
