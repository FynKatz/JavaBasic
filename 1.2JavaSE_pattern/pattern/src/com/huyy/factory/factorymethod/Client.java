package com.huyy.factory.factorymethod;

public class Client {
	
	public static void main(String[] args) {
		Car c1 = new AudiCarFactory().creatCar();
		Car c2 = new BydCarFactory().creatCar();
		
		c1.run();
		c2.run();
	}

}
