package com.huyy.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.huyy.entry.MessageIn;
import com.huyy.entry.MessageOut;

@Controller
public class MessageController {

	@MessageMapping("/messaging")
	@SendTo("/from:server/messaging")
	// @SendTo定义了消息的目的地。
	// 说明：接收"/from:app/messaging"发来的value，然后将value转发到"/from:server/messaging"客户端。
	public MessageOut messaging(MessageIn message) {
		return new MessageOut(message.getName() + " : " + message.getMessage());
	}
}
