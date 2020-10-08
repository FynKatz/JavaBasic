package com.huyy.factory.abstractfactory;

public class LuxuryEngine implements Engine {

	@Override
	public void run() {
		System.out.println("运行好");
	}

	@Override
	public void start() {
		System.out.println("启动好");
	}

}
