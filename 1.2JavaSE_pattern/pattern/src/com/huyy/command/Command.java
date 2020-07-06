package com.huyy.command;

/**
 * 命令接口
 * @author Administrator
 *
 */
public interface Command {
	
	//实际项目中，可以根据需求设计多个不同的方法
	public void execute();
}
