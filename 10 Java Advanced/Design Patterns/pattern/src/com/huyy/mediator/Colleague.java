package com.huyy.mediator;

public interface Colleague {

	public void setMediator(Mediator mediator);
	public void send();
	public void receive();
}
