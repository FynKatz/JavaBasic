package com.huyy.factory.abstractfactory;

public class LowSeat implements Seat {

	@Override
	public void run() {
		System.out.println("一般的座椅");
	}

}
