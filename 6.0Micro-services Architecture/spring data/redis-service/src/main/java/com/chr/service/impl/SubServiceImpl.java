package com.chr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;

import com.chr.domain.MessageList;
import com.chr.service.SubService;


public class SubServiceImpl implements SubService {
	@Autowired
	private ChannelTopic channelTopic;//和redis-context.xml中channelTopic的匹配(值为user:topic)

	private MessageList messageList = new MessageList();

	public void onMessage(Message message, byte[] pattern) {
		System.out.println(message.toString() + "  " + channelTopic.getTopic());
		messageList.add(message.toString());//接收消息后，把接收到的消息方法Redis队列
	}

	public MessageList getMessageList() {
		return messageList;
	}
}
