package com.huyy.singleton;

/*懒汉式（单例对象延迟加载）*/
public class Singleton02 {

	//类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）。
	private static Singleton02 instance;//2.定义一个静态私有实例
	
	private Singleton02() {//1.私有构造器
	}

	//方法同步synchronized，调用效率低！
	public static synchronized Singleton02 getInstance(){//3.静态的公有函数,用于创建或获取该静态私有实例
		if (instance == null) {
			instance = new Singleton02();
		}
		return instance;
	}
}
