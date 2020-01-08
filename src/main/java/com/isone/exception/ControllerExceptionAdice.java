package com.isone.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isone.common.base.ResultData;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionAdice {

	@ExceptionHandler(value = ServiceException.class)
	public ResultData myException(ServiceException sException) {
		ResultData resultData = new ResultData();
		resultData.setStatus(sException.getCode());
		resultData.setMsg(sException.getMessage());
		return resultData;		
	}
}
