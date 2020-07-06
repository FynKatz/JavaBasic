package com.huyy.socket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/*һ��Ҫ��/����Ȼ�ᱨ��(·������)*/
@ServerEndpoint("/echo")
public class EchoSocket {
	@OnOpen
	public void open(Session session) {// һ��session����һ���ܵ����Ự��
		System.out.println("websocket open..sessionId:" + session.getId());
	}
	
	@OnClose
	public void close(Session session){
		System.out.println("websocket�ѹر�");
	}
	
	@OnMessage
	public void message(Session session,String msg){
		System.out.println("�ͻ��ˣ�"+msg);//�ӿͻ��˽��տ�@OnMessageע��
		
		//���������͵��ͻ���
		try {
			session.getBasicRemote().sendText("����������ð�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
