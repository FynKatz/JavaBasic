package com.huyy.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.huyy.entry.Greeting;
import com.huyy.entry.User;

@Controller
public class LoginController {

	@MessageMapping("/login")
	@SendTo("/from:server/greetings")
	// @SendTo定义了消息的目的地。
	// 说明：接收"/from:app/login"发来的value，然后将value转发到"/from:server/greetings"客户端。
	public Greeting login(User user) {
		return new Greeting(user.getName() + " join the group chat...");
	}

	@MessageMapping("/logout")
	@SendTo("/from:server/greetings")
	public Greeting logout(User user) {
		return new Greeting(user.getName() + " left the group chat...");
	}
}
