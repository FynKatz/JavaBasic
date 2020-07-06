package com.huyy.builder;

public class ConcreteBuilder implements Builder {

	@Override
	public String buildPartA() {
		System.out.println("构建A零件");
		return new String("零件A");
	}

	@Override
	public String buildPartB() {
		System.out.println("构建B零件");
		return new String("零件B");
	}

	@Override
	public String buildPartC() {
		System.out.println("构建C零件");
		return new String("零件C");
	}

}
