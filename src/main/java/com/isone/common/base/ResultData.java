package com.isone.common.base;

public class ResultData {

	private final static String SUCCEED = "成功";
	
	private final static String STATUS = "200";
	
	private String status = STATUS;

	private String msg = SUCCEED;

	private Object data;

	/**
	 * constructor
	 */
	public ResultData() {
		
	}
	
	public ResultData(Object data) {		
		this.data = data;
	}
	
	public ResultData(Object data, String status) {
		this.status = status;
		this.data = data;
	}
	
	public ResultData(Object data, String status, String msg) {
		this.data = data;
		this.status = status;
		this.msg = msg;
	}
	/**
	 * get and set
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}



}
