package com.isone.rabbit.callback;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;

public class MsgSendChangeCallback implements ConfirmCallback {

	/**
	 * 消息发送到 交换机失败的回调
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("MsgSendChangeCallback");
		if(ack) {
			System.out.println("消息发送到交换机成功~："+correlationData+"=="+cause);
		} else {
			System.out.println("消息发送到交换机失败~："+cause+"===="+correlationData.getId());
		}
	}

}
