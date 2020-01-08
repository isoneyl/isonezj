package com.isone;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestRabbitMQTemplate {
	
	@Autowired
	private RabbitTemplate rabbit;
	
	
	/**
	 * 基本的发送
	 */
	@Test
	public void testSendMes() {
		
		rabbit.convertAndSend("Testone", "李云龙测试2----");
	}
	
	/**
	 * 基本的接收
	 */
	@Test
	public void testProcess() {
	}
}
