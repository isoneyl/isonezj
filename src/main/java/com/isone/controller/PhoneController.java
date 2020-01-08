package com.isone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.isone.common.base.ResultData;
import com.isone.exception.ServiceException;
import com.isone.mapper.PhoneMapper;
import com.isone.pojo.entity.PhoneDO;
import com.isone.rabbit.producer.TestProducer;

@RestController
@RequestMapping("api/")
public class PhoneController {
	@Autowired
	private PhoneMapper mapper;

	@Autowired
	private TestProducer producer;
	
	@RequestMapping(value = "queryPhone",method = RequestMethod.GET)
	public JSONPObject queryPhone(String num,String callback) {
		PhoneDO phoneDo = mapper.queryByNum(num);
		JSONPObject jsonpObject = new JSONPObject(callback, new ResultData(phoneDo));
		if(StringUtils.isEmpty(phoneDo)) {
			throw new ServiceException("1000","没有此数据记录","数据异常");
		}
		return jsonpObject;
	}
	
	/**
	 * 
	 * @Title: testMQ  
	 * @Description:
	 * @author: isonezj
	 * @date 2020年1月8日
	 */
	@RequestMapping(value = "testMQ",method = RequestMethod.GET)
	public void testMQ() {
		producer.send("testDirectExchange", "test.Direct", "我是直连交换机啊");
		producer.send("testTopicExchange", "test.topic.A", "我是主题交换机的 A 路由");
		producer.send("testTopicExchange", "test.topic.B", "我是主题交换机的 B 路由");
	}
}
