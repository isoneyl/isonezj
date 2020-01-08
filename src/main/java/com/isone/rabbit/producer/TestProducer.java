package com.isone.rabbit.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestProducer {
	@Autowired
	private RabbitTemplate rabbit;
	
	public void send(String msg) {
		rabbit.convertAndSend("testOne", msg);
	}
	
	public void send(String exchange, String routingKey, String msg) {
		rabbit.convertAndSend(exchange, routingKey, msg);
	}
}
