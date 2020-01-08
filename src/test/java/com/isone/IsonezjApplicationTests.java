package com.isone;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import com.isone.pojo.entity.PhoneDO;


@SpringBootTest
class IsonezjApplicationTests {
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 测试String 类型
	 */
	@Test
	public void testString() {
		redisTemplate.boundValueOps("name").set("李云龙");
		String name =(String) redisTemplate.boundValueOps("name").get();
		System.out.println("=========+："+name);
	}

	@Test
	public void testObject() {
		PhoneDO phone = new PhoneDO();
		phone.setId(1001);
		phone.setCity("河北省邢台市");
		phone.setNum("1573390");
		phone.setCardtype("河北邢台移动卡");
		redisTemplate.boundValueOps("num1").set(phone);
		Object object =(PhoneDO) redisTemplate.boundValueOps("num1").get();
		System.out.println(object);
	}
}
