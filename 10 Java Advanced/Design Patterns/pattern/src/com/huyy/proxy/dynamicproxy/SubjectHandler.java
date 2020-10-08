package com.huyy.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**  
* @Description: 动态代理的处理器。
* @author yyhu
* @date 2020年3月22日  
* @version V1.0  
*/
public class SubjectHandler implements InvocationHandler{

	RealSubject realSubject;//真实对象
	
	//构造器
	public SubjectHandler(RealSubject realSubject) {
		super();
		this.realSubject = realSubject;
	}

	//通过invoke方法实现对真实角色的代理访问
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("进入了处理器来调用真实对象的method");//测试
		method.invoke(realSubject, args);//对传入参数method及其参数args的调用
		
		return null;
	}

}
 