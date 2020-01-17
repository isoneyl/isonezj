package com.isone.common.base;

import java.io.Serializable;
import java.util.Date;

public class BaseDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6051746750094825480L;
	
	/**
	 * 创建时间
	 */
	protected Date createTime;
	
	/**
	 * 更新时间
	 */
	protected Date updateTime;

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
	
}
