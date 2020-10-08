package com.huyy.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicProducer {
    public static void main(String[] args) throws JMSException {
        //1 创建连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //2 获取连接
        Connection connection = connectionFactory.createConnection();
        //3 启动连接
        connection.start();
        //4 获取session(第一个参数为:是否启动事务  第二个参数为:消息确认的模式)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //5 创建队列对象
        Topic topic = session.createTopic("topic-mod01");
        //6 创建消息生产者
        MessageProducer producer = session.createProducer(topic);
        //7 创建消息
        TextMessage textMessage = session.createTextMessage("activemq hello2200");
        //8 发送消息
        producer.send(textMessage);
        //9 关闭资源
        producer.close();
        session.close();
        connection.close();
    }

}
