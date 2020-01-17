package com.isone.pojo.entity;

import java.util.Date;

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
	
	private String userPwd;
	
	private String phone;
	
	private String addr;
	
	private Date createTime;
	
	private Date updateTime;

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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "UserDO [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", phone=" + phone
				+ ", addr=" + addr + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
}
