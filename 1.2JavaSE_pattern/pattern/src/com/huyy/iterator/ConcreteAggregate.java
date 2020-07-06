package com.huyy.iterator;

import java.util.ArrayList;
import java.util.List;

/** 迭代器具体实现类
 * @author Administrator
 *
 */
public class ConcreteAggregate implements Aggregate {

	private List<Object> list = new ArrayList<Object>();
	
	@Override
	public void add(Object object) {
		list.add(object);
	}

	@Override
	public void remove(Object object) {
		list.remove(object);
	}

	@Override
	public Iterator getIterator() {
//		return new ConcreteIterator();
		return new ConcreteIterator2();//使用内部类
	}
	
	//使用内部类定义迭代器，可以直接使用外部类的属性
	class ConcreteIterator2 implements Iterator {

//		private List<Object> list = null;
		private int cursor = -1;
//		//构造器
//		public ConcreteIterator(List<Object> list) {
//			super();
//			this.list = list;
//		}

		@Override
		public Object first() {
			cursor = 0;
			return list.get(cursor);
		}

		@Override
		public Object next() {
			Object object = null;
			if (this.hasNext()) {
				object = list.get(++cursor);
			}
			return object;
		}

		@Override
		public boolean hasNext() {
			return cursor < list.size()-1 ? true : false;
		}
	}

}
