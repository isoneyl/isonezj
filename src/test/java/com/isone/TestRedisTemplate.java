package com.isone;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isone.pojo.entity.PhoneDO;

@SpringBootTest
public class TestRedisTemplate {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Test
	public void testString() {
		redisTemplate.opsForValue().set("name", "liyunlong");
	}

	@Test
	public void testObject() throws IOException {
		PhoneDO phone = new PhoneDO();
		phone.setId(1001);
		phone.setCity("河北省邢台市");
		phone.setNum("1573390");
		phone.setCardtype("河北邢台移动卡");
		ObjectMapper objectMapper = new ObjectMapper();
		String bytes = objectMapper.writeValueAsString(phone);
		System.out.println(bytes);
		PhoneDO readValue = objectMapper.readValue(bytes, PhoneDO.class);
		System.out.println(readValue);
		redisTemplate.opsForValue().set("phone", bytes);
		System.out.println(redisTemplate.opsForValue().get("phone"));
	}
}
