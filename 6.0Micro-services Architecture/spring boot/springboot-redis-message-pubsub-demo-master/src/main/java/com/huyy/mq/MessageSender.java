package com.huyy.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class MessageSender {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //发送消息
    @Scheduled(fixedRate = 2000)//定时2s发送
    public void sendMessage(){
        stringRedisTemplate.convertAndSend("chat",String.valueOf(Math.random()));//模拟发送消息
    }
}
