package com.huyy.memento;

public class Client {
	public static void main(String[] args) {
		
		Originator originator = new Originator("first");
		Caretaker caretaker = new Caretaker();
		System.out.println("第一次创建对象的状态："+originator.getState());
		
		//发起人创建备份，存储到管理者中保存
		caretaker.setMemento(originator.createMemento());
		originator.setState("changed");//发起人更改状态
		System.out.println("更改对象后的状态："+originator.getState());
		
		//恢复备份
		originator.recovery(caretaker.getMemento());
		System.out.println("备份恢复后的状态："+originator.getState());
		
	}
}
