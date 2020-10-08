package com.huyy.flyweight;

import java.util.HashMap;
import java.util.Map;

/** 享元工厂角色
 * @author Administrator
 *
 */
public class FlyweightFactory {
	//享元池
	private Map<String, Flyweight> flyweights = new HashMap<>();
	
	//获取享元
	public Flyweight getFlyweight(String key){
		Flyweight flyweight = flyweights.get(key);
		if (flyweight != null) {
			System.out.println("内部状态："+key+"被获取到");
		}else {
			flyweight = new ConcreteFlyweight(key);
			flyweights.put(key, flyweight);
			System.out.println("内部状态："+key+"被创建到享元池");
		}
		return flyweight;
	}
}
