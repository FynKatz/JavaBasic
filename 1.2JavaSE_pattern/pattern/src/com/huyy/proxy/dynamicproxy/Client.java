package com.huyy.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**  
* @Description: 
* @author yyhu
* @date 2020年3月22日  
* @version V1.0  
*/
public class Client {
	
	public static void main(String[] args) {
		Subject realSubject = new RealSubject();
		SubjectHandler handler = new SubjectHandler((RealSubject) realSubject);
		//动态代理返回的代理对象
		Subject proxy = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, handler);
		proxy.request();
	}

}
 