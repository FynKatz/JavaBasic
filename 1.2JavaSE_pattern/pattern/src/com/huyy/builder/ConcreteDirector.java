package com.huyy.builder;

public class ConcreteDirector implements Director {
	
	//创建构建者
	private Builder builder;
	
	//构造器
	public ConcreteDirector(Builder builder) {
		this.builder = builder;
	}

	@Override
	public Product directProduct() {
		
		//建造零件
		String partA = builder.buildPartA();
		String partB = builder.buildPartB();
		String partC = builder.buildPartC();
		
		//装配
		Product product = new Product();
		product.setPartA(partA);
		product.setPartB(partB);
		product.setPartC(partC);
				
		return product;
	}

}
