package com.isone;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import com.isone.mapper.UserMapper;
import com.isone.pojo.entity.PhoneDO;
import com.isone.pojo.entity.UserDO;


@SpringBootTest
class IsonezjApplicationTests {
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private UserMapper userMapper;

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
	
	@Test
	public void testAddUser() {
		UserDO userDO = new UserDO();
		userDO.setAddr("石家庄");
		userDO.setCreateTime(new Date());
		userDO.setPhone("13001801237");
		userDO.setUpdateTime(new Date());
		userDO.setUserId(1000001L);
		userDO.setUserPwd("123");
		userDO.setUserName("里李云龙");
		userMapper.saveUser(userDO);
	}
}
