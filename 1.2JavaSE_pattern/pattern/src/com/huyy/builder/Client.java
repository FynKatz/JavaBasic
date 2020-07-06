package com.huyy.builder;

public class Client {
	public static void main(String[] args) {
		
		Builder builder = new ConcreteBuilder();
		Director director = new ConcreteDirector(builder);
		
		Product product = director.directProduct();
		System.out.println(product);
		
	}
}
