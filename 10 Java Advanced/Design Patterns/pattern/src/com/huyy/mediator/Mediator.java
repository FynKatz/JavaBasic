package com.huyy.mediator;

/** 抽象中介接口
 * @author Administrator
 *
 */
public interface Mediator {
	public void register(Colleague colleague);//注册同事（管理）
	public void relay(Colleague colleague);//转发消息
}
