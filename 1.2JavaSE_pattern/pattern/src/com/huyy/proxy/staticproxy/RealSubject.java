package com.huyy.proxy.staticproxy; 

/**  
* @Description: 实际角色
* @author yyhu
* @date 2020年3月21日  
* @version V1.0  
*/
public class RealSubject implements Subject {

	@Override
	public void request() {
		System.out.println("访问真实角色的方法...");
	}
}
 