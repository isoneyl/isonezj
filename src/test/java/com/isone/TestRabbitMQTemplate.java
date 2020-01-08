package com.isone;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRabbitMQTemplate {
	
	@Autowired
	private RabbitTemplate rabbit;
	
	@Test
	public void testSendMes() {
		rabbit.afterPropertiesSet();
	}
}
