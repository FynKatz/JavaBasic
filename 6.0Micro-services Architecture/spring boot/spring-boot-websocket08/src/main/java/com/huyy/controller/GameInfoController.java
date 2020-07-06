package com.huyy.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huyy.model.InMessage;
import com.huyy.model.OutMessage;

@Controller
public class GameInfoController {

	@MessageMapping("/chat")
	@SendTo("/topic/game_chat")
	// @SendTo定义了消息的目的地。
	// 说明：接收"/app/chat"发来的value，然后将value转发到"/topic/game_chat"客户端。
	public OutMessage gameInfo(InMessage message) {
		return new OutMessage(message.getContent());
	}

}
