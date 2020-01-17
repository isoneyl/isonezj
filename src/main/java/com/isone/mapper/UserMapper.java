package com.isone.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.isone.pojo.entity.UserDO;

@Mapper
public interface UserMapper {

	/**
	 * 添加用户
	 * @Title: saveUser  
	 * @Description:
	 * @param user
	 * @return
	 * @author：isonezj
	 * @date 2020年1月16日
	 */
	int saveUser(UserDO user);
	
	/**
	 * 分页查询
	 * @Title: pageByQueey  
	 * @Description:
	 * @return
	 * @author：isonezj
	 * @date 2020年1月16日
	 */
	List<UserDO> pageByQuery();
	
}
