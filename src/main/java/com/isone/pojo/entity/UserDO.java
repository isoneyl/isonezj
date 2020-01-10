package com.isone.pojo.entity;

import com.isone.common.base.BaseDO;

/**
 * 用户实体类
 *@class_name：UserDo
 *@comments:
 *@param:
 *@return: 
 *@author:isonezj
 *@createtime:2020年1月10日
 */
public class UserDO extends BaseDO {

	/** serialVersionUID*/
	private static final long serialVersionUID = 181253833085673827L;
	
	private Long userId;
	
	private String userName;
	
	private String password;
	
	private String phone;
	
	private String addr;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "UserDO [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phone=" + phone
				+ ", addr=" + addr + "]";
	}
	
}
