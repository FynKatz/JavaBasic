package com.huyy.strategy;

/** 具体策略类A
 * @author Administrator
 *
 */
public class ConcreteStrategyA implements Strategy {

	@Override
	public void strategyMethod() {
		System.out.println("具体策略A的策略方法被执行");
	}
}
