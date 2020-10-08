package com.huyy.flyweight;

/**
 * 抽象享元角色。
 * @author Administrator
 *
 */
public interface Flyweight {
	//内部状态的公共接口
	public String getKey();
	
	//外部状态以参数的形式注入具体享元的相关方法中
	public void operation(UnsharedConcreteFlyweight state);
}
