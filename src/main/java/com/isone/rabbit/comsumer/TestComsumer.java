package com.isone.rabbit.comsumer;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
public class TestComsumer {

	@RabbitListener(queues = "testOne")
	public void process(String msg) throws IOException {
		System.out.println("=====11111======="+msg);
	}
	
	@RabbitListener(queues = "testTwo")
	public void processTwo(String msg) throws IOException {
		System.out.println("=====22222======="+msg);
	}
	
	@RabbitListener(queues = "testThree")
	public void processThree(String msg) throws IOException {
		System.out.println("=====33333======="+msg);
	}
	
}
