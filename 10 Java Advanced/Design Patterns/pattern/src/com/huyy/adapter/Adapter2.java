package com.huyy.adapter; 

/**  
* @Description: 适配器类（对象结构性模式）
* @author yyhu
* @date 2020年3月21日  
* @version V1.0  
*/
public class Adapter2 implements Target {
	
	Adaptee adaptee;
	
	//构造器
	public Adapter2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		adaptee.specificRequest();
	}

}
 