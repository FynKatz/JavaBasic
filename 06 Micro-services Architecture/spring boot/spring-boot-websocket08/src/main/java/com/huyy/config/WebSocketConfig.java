package com.huyy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 设置客户端接收地址的前缀，也就是服务端给客户端发消息的地址的前缀
		registry.enableSimpleBroker("/topic");
		// 设置服务器接收地址的前缀，也就是客户端给服务端发消息的地址的前缀
		registry.setApplicationDestinationPrefixes("/app");

	}

	/* 添加一个服务端点，来接收客户端的连接 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// 添加了一个"/endpoint-websocket"端点，客户端就可以通过这个端点来进行连接。
		registry.addEndpoint("/endpoint-websocket").withSockJS();// withSockJS()的作用是开启SockJS支持
	}
}
