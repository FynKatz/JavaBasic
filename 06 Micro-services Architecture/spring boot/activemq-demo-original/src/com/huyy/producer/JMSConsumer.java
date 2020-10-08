package com.huyy.producer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
 
public class JMSConsumer {
    //默认连接名称
    private static  String USER= ActiveMQConnection.DEFAULT_USER;
    //默认密码
    private static  String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
    private static String URL=ActiveMQConnection.DEFAULT_BROKER_URL;
 
    public static void main(String[] args) {
       //连接工厂
        ConnectionFactory connectionFactory;
        //连接
        Connection connection;
        //会话 接收或发送消息的进程
        Session session;
        //消息的目的地
        Destination destination;
        //消息的消费者
        MessageConsumer messageConsumer;
        //实例化连接工厂
        connectionFactory=new ActiveMQConnectionFactory(JMSConsumer.USER,JMSConsumer.PASSWORD,JMSConsumer.URL);
 
        try {
            //通过连接工厂获取连接
            connection=connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //创建一个HelloWorld的消息队列
            destination=session.createQueue("HelloWorld");
            //创建消息消费者
            messageConsumer = session.createConsumer(destination);
 
            while(true){
                TextMessage message = (TextMessage) messageConsumer.receive(100000);
                if(message!=null){
                    System.out.println("收到的消息:"+message.getText());
                }else{
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}