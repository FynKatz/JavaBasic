package com.huyy.factory.abstractfactory;

public class LowEngine implements Engine {

	@Override
	public void run() {
		System.out.println("运行一般");
	}

	@Override
	public void start() {
		System.out.println("启动慢");
	}

}
