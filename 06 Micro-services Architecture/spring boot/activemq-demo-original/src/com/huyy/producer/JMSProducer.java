package com.huyy.producer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
 
import javax.jms.*;
 
public class JMSProducer {
 
    //默认连接用户名
    private static final String USER= ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
    private static final String URL=ActiveMQConnection.DEFAULT_BROKER_URL;
    //发送的消息数量
    private static final int SENDNUM=10;
 
    public static void main(String[] args) throws JMSException {
        //连接工厂
        ConnectionFactory connectionFactory;
        //连接
        Connection connection;
        //会话(接收或发送消息的线程)
        Session session;
        //消息目的地
        Destination destination;
        //消息生产者
        MessageProducer messageProducer;
        //实例化连接工厂
        connectionFactory=new ActiveMQConnectionFactory(JMSProducer.USER,JMSProducer.PASSWORD,JMSProducer.URL);
 
 
        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session=connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            //创建一个名称为HelloWorld的消息队列
            destination= session.createQueue("HelloWorld");
            //创建消息生产者
            messageProducer = session.createProducer(destination);
            //发送消息
            sendMessage(session,messageProducer);
            //提交
            session.commit();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
 
    public static void sendMessage(Session session,MessageProducer messageProducer) throws Exception{
        for (int i=0;i<JMSProducer.SENDNUM;i++){
            //创建需要发送的消息
            TextMessage message = session.createTextMessage("ActiveMQ发送消息:" + i);
            System.out.println("ActiveMQ发送消息:"+i);
            messageProducer.send(message);
        }
    }
}
