package com.huyy.proxy.staticproxy;

import com.huyy.proxy.dynamicproxy.RealSubject;
import com.huyy.proxy.dynamicproxy.Subject;

/**  
* @Description: 代理
* @author yyhu
* @date 2020年3月21日  
* @version V1.0  
*/
public class Proxy implements Subject {

	private RealSubject realSubject;
	
	//构造器
	public Proxy(RealSubject realSubject) {
		this.realSubject = realSubject;
	}

	@Override
	public void request() {
		realSubject.request();//代理管理真实角色的方法
	}

}
 