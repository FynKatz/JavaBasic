package com.huyy.proxy.staticproxy;

import com.huyy.proxy.dynamicproxy.RealSubject;
import com.huyy.proxy.dynamicproxy.Subject;

/**
 * @Description:客户端
 * @author yyhu
 * @date 2020年3月21日
 * @version V1.0
 */
public class Client {
	public static void main(String[] args) {
		Subject realSubject = new RealSubject();//真实对象
		Subject proxy = new Proxy((RealSubject) realSubject);//代理对象
		
		proxy.request();//代理调用真实对象的方法		
	}
}
