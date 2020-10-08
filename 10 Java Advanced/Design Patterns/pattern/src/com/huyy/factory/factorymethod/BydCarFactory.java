package com.huyy.factory.factorymethod;

public class BydCarFactory implements CarFactory{

	@Override
	public Car creatCar() {
		return new Byd();
	}

}
