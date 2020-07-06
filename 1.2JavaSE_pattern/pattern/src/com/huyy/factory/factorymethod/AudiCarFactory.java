package com.huyy.factory.factorymethod;

public class AudiCarFactory implements CarFactory{

	@Override
	public Car creatCar() {
		return new Audi();
	}

}
