package com.huyy.factory.abstractfactory;

public class LowCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		return new LowEngine();
	}

	@Override
	public Seat createSeat() {
		return new LowSeat();
	}

}
