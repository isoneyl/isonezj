package com.isone.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Bean(name = "testOne")
	public Queue testOne() {
		return new Queue("testOne");
	}

	@Bean(name = "testTwo")
	public Queue testTwo() {
		return new Queue("testTwo");
	}

	
	@Bean(name = "testThree")
	public Queue testThree() {
		return new Queue("testThree");
	}

	/**
	 * 定义交换机
	 * 主题交换机
	 */
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("testTopicExchange");
	}

	/**
	 * 定义直连交换机
	 */
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("testDirectExchange");
	}

	/**
	 * 绑定交换机和队列2
	 */
	@Bean
	public Binding bindingOne(@Qualifier(value = "testOne") Queue testOne,DirectExchange directExchange) {

		return BindingBuilder.bind(testOne).to(directExchange).with("test.Direct");
	}

	/**
	 * 绑定交换机和队列2
	 */
	@Bean
	public Binding binding(@Qualifier(value = "testTwo") Queue testTwo,TopicExchange topicExchange) {
		return BindingBuilder.bind(testTwo).to(topicExchange).with("test.topic.A");
	}

	/**
	 * 绑定交换机和队列3
	 */
	@Bean
	public Binding bindings(@Qualifier(value = "testThree") Queue testThree,TopicExchange topicExchange) {
		return BindingBuilder.bind(testThree).to(topicExchange).with("test.topic.B");
	}
}
