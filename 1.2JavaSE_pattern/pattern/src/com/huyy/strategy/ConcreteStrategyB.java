package com.huyy.strategy;

/** 具体策略类B
 * @author Administrator
 *
 */
public class ConcreteStrategyB implements Strategy {

	@Override
	public void strategyMethod() {
		System.out.println("具体策略B的策略方法被执行");
	}
}
