package com.huyy.flyweight;

public class Client {
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight f1 = factory.getFlyweight("A");
		System.out.println();
		
		Flyweight f2 = factory.getFlyweight("A");
		System.out.println();
		
		f1.operation(new UnsharedConcreteFlyweight("A的outKey"));
		Flyweight f3 = factory.getFlyweight("A");
		System.out.println();
		
		f1.operation(new UnsharedConcreteFlyweight("A的outKey2"));
		Flyweight f4 = factory.getFlyweight("A");
	}
}
