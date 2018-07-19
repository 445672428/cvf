package com.cache;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class CustomMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		// 先将接收到的消息强转为ActiveMQ类型的消息
		// 因为在消息发送方那边传递的是Text类型的消息对象, 所以需要转成ActiveMQTextMessage
	}

}
