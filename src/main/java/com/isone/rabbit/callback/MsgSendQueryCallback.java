package com.isone.rabbit.callback;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;

public class MsgSendQueryCallback implements ReturnCallback {

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		
		System.out.println("消息从路由器到队列发送失败！："+new String(message.getBody()));
	}

}
