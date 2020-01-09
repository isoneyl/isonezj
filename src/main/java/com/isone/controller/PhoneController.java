package com.isone.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@RequestMapping(value = "query",method = RequestMethod.GET)
	public List<Map<String,String>> queryPhone() {
		Map<String,String> map = new HashMap<String,String>();
		Map<String,String> map2 = new HashMap<String,String>();
		Map<String,String> map3 = new HashMap<String,String>();
		map.put("name", "张晶");
		map2.put("name", "李云龙");
		map3.put("name", "小宝宝");
		List<Map<String,String>> list = new ArrayList<>();
		list.add(map);
		list.add(map2);
		list.add(map3);
		return list;
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
