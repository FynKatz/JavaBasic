package com.huyy.singleton;

/**
 * 测试静态内部类实现单例模式
 * 这种方式：线程安全，调用效率高，并且实现了延时加载！
 */
public class Singleton04 {
	//注意：加载类时，不会初始化静态内部类。

	//2.创建静态内部类，里面创建单例对象。
	private static class SingletonClassInstance{
		private static /*final*/ Singleton04 instance = new Singleton04();
	}
		
	private Singleton04() { //1.私有构造器
	}
	
	public static Singleton04 getInstance(){//3.创建方法，获取静态内部类的实例对象
		//直到调用静态内部类SingletonClassInstance，才会加载它。
		return SingletonClassInstance.instance;
	}
	
}
