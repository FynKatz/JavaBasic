package com.huyy.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class TopicConsumer {
    public static void main(String[] args) throws JMSException, IOException {
        //1 创建连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //2 获取连接
        Connection connection = connectionFactory.createConnection();
        //3 启动连接
        connection.start();
        //4 获取session(第一个参数为:是否启动事务  第二个参数为:消息确认的模式)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //5 创建topic话题名称
        Topic topic = session.createTopic("topic-mod01");
        //6 创建消息消费者
        MessageConsumer consumer = session.createConsumer(topic);
        //7 监听消息(匿名内部类)
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage message1 = (TextMessage) message;
                try {
                    System.out.println("接收到消息:"+message1.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //8 等待键盘输入  为了能够接收到信息
        System.in.read();
        //9 关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
