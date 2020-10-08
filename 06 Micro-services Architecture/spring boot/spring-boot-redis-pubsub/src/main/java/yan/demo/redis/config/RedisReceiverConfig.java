package yan.demo.redis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import yan.demo.redis.support.OtherReceiver;
import yan.demo.redis.support.TestReceiver;

import java.util.Arrays;

/**
 * redis订阅适配器配置类
 * @author yanjunhao
 * @date 2017年12月5日
 */
@Configuration
public class RedisReceiverConfig {
    private Logger logger = LoggerFactory.getLogger(RedisReceiverConfig.class);

    /**
     * Redis消息监听器容器
     * 这个容器加载了RedisConnectionFactory和消息监听器
     *
     * @param connectionFactory   RedisConnectionFactory
     * @param testListenerAdapter MessageListenerAdapter
     * @return RedisMessageListenerContainer
     */
    @Bean
    RedisMessageListenerContainer container(@Qualifier(value = "RedisConnectionFactory") RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter testListenerAdapter,
                                            MessageListenerAdapter otherListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(testListenerAdapter, Arrays.asList(new PatternTopic("test"), new PatternTopic("test2")));
        logger.info("init test topic listener");
        container.addMessageListener(otherListenerAdapter, new PatternTopic("other"));
        logger.info("init other topic listener");
        return container;
    }


    /**
     * 将Receiver注册为一个消息监听器，并指定消息接收的方法（receiveMessage）
     * 如果不指定消息接收的方法，消息监听器会默认的寻找Receiver中的handleMessage这个方法作为消息接收的方法
     *
     * @param receiver TestReceiver
     * @return MessageListenerAdapter
     */
    @Bean
    MessageListenerAdapter testListenerAdapter(TestReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    MessageListenerAdapter otherListenerAdapter(OtherReceiver otherReceiver) {
        return new MessageListenerAdapter(otherReceiver, "receiveMessage");
    }

    /**
     * Receiver实例
     */
    @Bean
    TestReceiver receiver() {
        return new TestReceiver();
    }

    /**
     * Receiver实例
     */
    @Bean
    OtherReceiver otherReceiver() {
        return new OtherReceiver();
    }
}
