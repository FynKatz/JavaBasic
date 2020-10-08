package com.huyy.mq;

import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    /**接收消息的方法*/
    public void receiveMessage(String message){
        System.out.println("收到一条消息："+message);//控制台打印（也可以通过控制器输出到页面）
    }

}
