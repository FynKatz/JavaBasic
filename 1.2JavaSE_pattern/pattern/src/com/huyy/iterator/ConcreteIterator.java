package com.huyy.iterator;

import java.util.List;

/** 具体迭代器
 * @author Administrator
 *
 */
public class ConcreteIterator implements Iterator {

	private List<Object> list = null;
	private int cursor = -1;
	//构造器
	public ConcreteIterator(List<Object> list) {
		super();
		this.list = list;
	}

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
