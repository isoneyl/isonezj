package com.isone.rabbit.producer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TestProducer {
	@Autowired
	private RabbitTemplate rabbit;
	
	public void send(String msg) {
		rabbit.convertAndSend("testOne", msg);
	}
	
	/**
	 * 普通的发送 交换机，路由键，消息
	 */
	public void send(String exchange, String routingKey, Object msg) {
		rabbit.convertAndSend(exchange, routingKey, msg);
		
	}
	
	/**
	 * 绑定ID的消息队列
	 */
	public void send(String exchange, String routingKey, Object mesobj,String mesgId ) {
		
		String obj =(String) mesobj;
		String msgId = mesgId;
		Message msg = MessageBuilder.withBody(obj.getBytes()).setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN).setClusterId(msgId).build();
		
		//讲消息 ID和 correlationData 绑定
		CorrelationData correlationData = new CorrelationData(msgId);
		rabbit.convertAndSend(exchange, routingKey, msg,  correlationData);
	}
}
