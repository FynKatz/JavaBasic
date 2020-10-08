package com.huyy.iterator;

/** 迭代器抽象接口
 * @author Administrator
 *
 */
public interface Aggregate {
	public void add(Object object);//增加元素
	public void remove(Object object);//减少
	public Iterator getIterator();//获取迭代器
}
