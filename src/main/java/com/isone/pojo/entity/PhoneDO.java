package com.isone.pojo.entity;

import com.isone.common.base.BaseDO;

/**
 * 
 * @author 11304
 * 实体类
 */
public class PhoneDO  extends BaseDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4995024389283508371L;

	private Integer id;
	
	private String num;
	
	private String city;
	
	private String cardtype;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	@Override
	public String toString() {
		return "PhoneDO [id=" + id + ", num=" + num + ", city=" + city + ", cardtype=" + cardtype + "]";
	}

	
}
