package com.huyy.decoretor;

/**
 * 具体装饰类（子类）
 * @author Administrator
 *
 */
public class ConcreteDecorator2 extends Decorator{
	//构造器
	public ConcreteDecorator2(Component component) {
		super(component);
	}

	@Override
	public void operation() {
		super.operation();//复用父类的方法
		newMethod2();//调用子类自定义方法
	}

	private void newMethod2() {
		System.out.println("新建具体装饰类的新方法2");		
	}	
}
