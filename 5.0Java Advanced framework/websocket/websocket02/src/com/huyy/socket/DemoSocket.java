package com.huyy.socket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/*����˵����һ���ͻ������Ӻ󣬻��½�һ����������DemoSocket��Ķ���*/
/**
 * @ServerEndpoint ע����һ�����ε�ע�⣬���Ĺ�����Ҫ�ǽ�Ŀǰ���ඨ���һ��websocket��������,
 * ע���ֵ�������ڼ����û����ӵ��ն˷���URL��ַ,�ͻ��˿���ͨ�����URL�����ӵ�WebSocket��������
 */
@ServerEndpoint("/websocket")/*һ��Ҫ��/����Ȼ�ᱨ��(·������)*/
public class DemoSocket {
    //��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�
    private static int onlineCount = 0;

    //concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��WebSocket����
    private static CopyOnWriteArraySet<DemoSocket> webSocketSet = new CopyOnWriteArraySet<DemoSocket>();

    //һ��session����һ���ܵ����Ự����һ���ͻ��˶�Ӧһ��session��
    private Session session;// 

    /**
     * ���ӽ����ɹ����õķ������ͻ��˴������������URL��
     * @param session  ��ѡ�Ĳ�����
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);     //����set��
        addOnlineCount();           //��������1
        System.out.println("�������Ӽ��룡��ǰ��������Ϊ" + getOnlineCount());
    }

    /**
     * ���ӹرյ��õķ������ͻ��˹ر��������
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);  //��set��ɾ��
        subOnlineCount();           //��������1
        System.out.println("��һ���ӹرգ���ǰ��������Ϊ" + getOnlineCount());
    }

    /**
     * �յ��ͻ�����Ϣ����õķ���
     * @param message �ͻ��˷��͹�������Ϣ
     * @param session ��ѡ�Ĳ���
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("���Կͻ��˵���Ϣ:" + message);
        //Ⱥ����Ϣ�����������յ��ͻ�����Ϣ��Ⱥ����Ϣ��
        for(DemoSocket item: webSocketSet){
            try {
            	//�����̳߳��е�WebSocket����,�����Ƿ�����Ϣ
            	item.session.getBasicRemote().sendText(message);
                //item.sendMessage(message);//��һ��д��
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * ��������ʱ����
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("��������");
        error.printStackTrace();
    }

    /**
     * ������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ��ӵķ�����
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        DemoSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        DemoSocket.onlineCount--;
    }
}