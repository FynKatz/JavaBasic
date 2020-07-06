package com.huyy.iterator;

/**
 * 抽象迭代器接口
 * @author Administrator
 *
 */
public interface Iterator {
	Object first();//返回第一个元素
	Object next();//返回下一个元素/当第一次时是第一个元素
	boolean hasNext();//是否有下一个元素
}
