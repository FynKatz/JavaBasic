package com.huyy.flyweight;

/** 非享元角色
 * @author Administrator
 *
 */
public class UnsharedConcreteFlyweight {	
	private String info;// 外部状态
	//构造器
	UnsharedConcreteFlyweight(String info) {
		this.info = info;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
