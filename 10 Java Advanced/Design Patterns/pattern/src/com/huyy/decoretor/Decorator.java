package com.huyy.decoretor;

/**
 * 抽象装饰类(父类)
 * @author Administrator
 *
 */
public class Decorator implements Component {

	private Component component;//具体构件的引用
	//构造器
	public Decorator(Component component) {
		super();
		this.component = component;
	}
	
	@Override
	public void operation() {
		component.operation();//直接调用具体构件的方法
	}
	
}
