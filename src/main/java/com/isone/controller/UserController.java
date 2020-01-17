package com.isone.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isone.common.base.ResultData;
import com.isone.mapper.UserMapper;
import com.isone.pojo.entity.UserDO;

@RestController
@RequestMapping("api/user/")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ResultData saveUser(@RequestBody UserDO userDo) {
		userDo.setUserId((new Random().nextLong()));
		userDo.setCreateTime(new Date());
		userDo.setUpdateTime(userDo.getCreateTime());
		int rt = userMapper.saveUser(userDo);
		System.err.println("========"+rt);
		if(rt==0) {
			return  new ResultData("保存失败！");
		}
		return new ResultData("保存成功！");
	}

}
