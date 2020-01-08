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

@RestController
@RequestMapping("api/")
public class PhoneController {
	@Autowired
	private PhoneMapper mapper;

	@RequestMapping(value = "queryPhone",method = RequestMethod.GET)
	public JSONPObject queryPhone(String num,String callback) {
		PhoneDO phoneDo = mapper.queryByNum(num);
		JSONPObject jsonpObject = new JSONPObject(callback, new ResultData(phoneDo));
		if(StringUtils.isEmpty(phoneDo)) {
			throw new ServiceException("1000","没有此数据记录","数据异常");
		}
		return jsonpObject;
	}
}
