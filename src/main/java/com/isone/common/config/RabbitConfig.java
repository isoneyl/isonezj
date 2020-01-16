package com.isone.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.isone.rabbit.callback.MsgSendChangeCallback;
import com.isone.rabbit.callback.MsgSendQueryCallback;

@Configuration
public class RabbitConfig {
	
	@Autowired
	private ConnectionFactory connectionFactory;

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
	public Binding bindingTwo(@Qualifier(value = "testTwo") Queue testTwo,TopicExchange topicExchange) {
		return BindingBuilder.bind(testTwo).to(topicExchange).with("test.topic.A");
	}

	/**
	 * 绑定交换机和队列3
	 */
	@Bean
	public Binding bindingThree(@Qualifier(value = "testThree") Queue testThree,TopicExchange topicExchange) {
		return BindingBuilder.bind(testThree).to(topicExchange).with("test.topic.B");
	}
	
	/**
	 *  讲发送路由失败回调类 注入到Bean
	 */
	@Bean
	public MsgSendChangeCallback msgSendChangeCallback() {
		return new MsgSendChangeCallback();
	}
	
	/**
	 *  讲发送队列失败回调类 注入到Bean
	 */
	@Bean
	public MsgSendQueryCallback msgSendQueryCallback() {
		return new MsgSendQueryCallback();
	}
	
	/**
	 * 配置 RabbitTemplate
	 */
	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		//设置 confirm 回调
		template.setConfirmCallback(this.msgSendChangeCallback());
		
		//设置 query回调
		template.setReturnCallback(this.msgSendQueryCallback());
		// mandatory 的值为 true
		template.setMandatory(true);
		
		
		return template;
	}
	
}
