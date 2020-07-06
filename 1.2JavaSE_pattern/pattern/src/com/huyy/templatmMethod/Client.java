package com.huyy.templatmMethod;

public class Client {
	public static void main(String[] args) {
		AbstractClass tm=new ConcreteClass();
        tm.TemplateMethod();//调用模板方法
	}
}
