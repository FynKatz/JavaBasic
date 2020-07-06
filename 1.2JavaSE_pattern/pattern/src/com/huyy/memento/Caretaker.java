package com.huyy.memento;

/** 管理者
 * @author Administrator
 *
 */
public class Caretaker {
	
	//这里还可以用容器存储多个时间点的数据备份。
	Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}
