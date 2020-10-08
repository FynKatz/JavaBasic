package com.huyy.decoretor;

/**
 * 具体构件
 * @author Administrator
 *
 */
public class ConcreteComponent implements Component{
	
	//构造器
	public ConcreteComponent() {
		super();
		System.out.println("创建具体构件");
	}

	@Override
	public void operation() {
		System.out.println("具体构件的operation()被调用");	
	}
}
