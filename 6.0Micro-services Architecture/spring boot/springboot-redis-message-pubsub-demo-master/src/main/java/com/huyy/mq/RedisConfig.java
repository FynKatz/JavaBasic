package com.huyy.mq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration //相当于xml中的beans
public class RedisConfig {

    /**
     * redis消息监听器容器：可以添加多个能监听不同channel的redis监听器。只需要把消息监听器和相应的消息订阅处理器绑定，
     * 该消息监听器通过反射技术调用消息,订阅处理器的相关方法进行一些业务处理。
     */
    @Bean //相当于xml中的bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));//订阅"chat"的channel通道
        return container;
    }

    /**消息监听器适配器：绑定消息处理器，利用反射技术调用消息处理器的业务方法*/
    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceiver receiver) {
        //给messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“receiveMessage”
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    /**创建StringRedisTemplate对象 */
    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

}
