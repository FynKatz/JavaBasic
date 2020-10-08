package com.huyy.iterator;

/** 客户端
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		Aggregate aggregate = new ConcreteAggregate();		
		aggregate.add("aa");
		aggregate.add("bb");
		aggregate.add("cc");
		aggregate.add("dd");
		
		//迭代器遍历
		Iterator iterator = aggregate.getIterator();
		while(iterator.hasNext()){
			Object object = iterator.next();
			System.out.println(object);
		}
		
		System.out.println("第一个元素："+iterator.first());
	}

}
