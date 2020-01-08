package com.isone.exception;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1312853815473807845L;
	
	private String code;  //异常状态码

	private String message;  //异常信息

	private String method;   //发生的方法，位置等

	private String descinfo;   //描述

	public ServiceException(String code, String message, String descinfo) {
		this.code=code;
		this.message=message;
		this.descinfo=descinfo;
	}
	
	public ServiceException(String code, String message, String method, String descinfo) {
		this.code=code;
		this.message=message;
		this.method=method;
		this.descinfo=descinfo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDescinfo() {
		return descinfo;
	}

	public void setDescinfo(String descinfo) {
		this.descinfo = descinfo;
	}
}
