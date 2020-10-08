package com.huyy.mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
	
	private List<Colleague> colleagues = new ArrayList<Colleague>();//同事管理集合
	
	@Override
	public void register(Colleague colleague) {
		if (!colleagues.contains(colleague)) {
			colleagues.add(colleague);//集合内添加同事对象
			colleague.setMediator(this);//该同事也设置中介者对象
		}
	}

	@Override
	public void relay(Colleague colleague) {
		for (Colleague col : colleagues) {
			if (!col.equals(colleague)) {
				col.receive();//向除自己外的同事转发，当然可以改变if规则进行指定转发。
			}
		}
	}

}
