package com.isone.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.isone.pojo.entity.PhoneDO;

@Mapper
public interface PhoneMapper {

	/**
	 * 查询归属地
	 * @param num
	 * @return
	 */
	PhoneDO queryByNum(String num);
}
