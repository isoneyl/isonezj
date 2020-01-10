package com.isone;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.isone.common.util.JsonUtil;
import com.isone.pojo.entity.UserDO;

@SpringBootTest
public class TestJSON {
	
	@Test
	public void testObjToJson() {
		UserDO user = new UserDO();
		user.setUserId(1130475930L);
		user.setUserName("李云龙");
		user.setPhone("15733900");
		user.setAddr("石家庄");
		//
		UserDO user2 = new UserDO();
		user2.setUserId(1130475931L);
		user2.setUserName("啊啊啊");
		user2.setPhone("15713200");
		user2.setAddr("邢台市");
		//
//		String json = JsonUtil.objToJson(user);
//		System.out.println(json);
//		System.out.println("=====================");
//		UserDO obj = JsonUtil.jsonToObject(json, UserDO.class);
//		System.out.println(obj);
		List<UserDO> list = new ArrayList<>();
		list.add(user);
		list.add(user2);
		String jsonList = JsonUtil.objToJson(list);
		System.out.println(jsonList);
		System.out.println("=====================");
		List objList = JsonUtil.jsonToObject(jsonList, List.class);
		System.out.println(objList);
	}
}
