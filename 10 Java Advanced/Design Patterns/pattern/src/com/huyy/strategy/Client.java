package com.huyy.strategy;

/** 客户端
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		Strategy strategy = new ConcreteStrategyB();
		Context context = new Context(strategy);
		
		context.getStrategy().strategyMethod();//执行策略
	}
}
