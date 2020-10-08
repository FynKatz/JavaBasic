package com.huyy.flyweight;

/** 具体享元角色
 * @author Administrator
 *
 */
public class ConcreteFlyweight implements Flyweight {

	String key;//内部状态key(共享)
	//构造器
	public ConcreteFlyweight(String key) {
		super();
		this.key = key;
		System.out.println("内部状态："+key+"被创建");
	}
	
	//内部状态的公共接口方法
	@Override
	public String getKey() {
		return key;
	}
	
	//外部状态以参数的形式注入具体享元的相关方法中
	@Override
	public void operation(UnsharedConcreteFlyweight state) {
		System.out.println("内部状态："+key+" +  外部状态："+state.getInfo()+"被调用");
	}
}
