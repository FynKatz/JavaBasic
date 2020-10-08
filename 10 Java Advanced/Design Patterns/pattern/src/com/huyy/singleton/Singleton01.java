package com.huyy.singleton;

/*饿汉式（类加载时即创建单例对象）*/
public class Singleton01 {

	//类初始化时，立即加载这个对象（没有延时加载的优势）。加载类时，天然的是线程安全的！
	private static Singleton01 instance = new Singleton01();//2.定义一个静态私有实例
	
	private Singleton01() {//1.私有构造器
	}

	//方法没有同步synchronized，调用效率高！
	public static /*synchronized*/ Singleton01 getInstance(){//3.静态的公有函数,用于创建或获取该静态私有实例
		return instance;
	}
}
