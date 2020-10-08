package com.huyy.socket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/*一定要加/，不然会报错(路径错误)*/
@ServerEndpoint("/echo")
public class EchoSocket {
	@OnOpen
	public void open(Session session) {// 一个session代表一个管道（会话）
		System.out.println("websocket open..sessionId:" + session.getId());
	}
	
	@OnClose
	public void close(Session session){
		System.out.println("websocket已关闭");
	}
	
	@OnMessage
	public void message(Session session,String msg){
		System.out.println("客户端："+msg);//从客户端接收靠@OnMessage注解
		
		//服务器发送到客户端
		try {
			session.getBasicRemote().sendText("服务器：你好啊");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
