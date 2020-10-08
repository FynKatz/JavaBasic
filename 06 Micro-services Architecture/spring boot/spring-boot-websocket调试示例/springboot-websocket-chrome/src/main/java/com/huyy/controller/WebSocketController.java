package com.huyy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate messageTemplate;

    /**
     * 订阅
     */
    @SubscribeMapping("/getResponse")
    public void subOnTopic(StompHeaderAccessor stompHeaderAccessor) throws Exception {
        System.out.println("有新用户订阅");
    }
    
    /**
     * 消息模式
     */
    @MessageMapping("/send/{message}")    
    public void sendTopic(@DestinationVariable("message") String message,
            StompHeaderAccessor stompHeaderAccessor) throws Exception {
        System.out.println("接收到消息"+message);
        String string = "hello";
        this.messageTemplate.convertAndSend("/topic/getResponse", string);
    }
}
