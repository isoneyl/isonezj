package com.isone.common.util;
/**
 * Json 工具类
 *@class_name：JsonUtil
 *@comments:
 *@param:
 *@return: 
 *@author:isonezj
 *@createtime:2020年1月10日
 */

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	private static ObjectMapper objMapper = new ObjectMapper();
	
	/**
	 *  对象转化为 JSON 字符串
	 */
	public static <T>String objToJson(T obj) {
		if(obj == null) return null;
		
		try {
			return obj instanceof String ? (String) obj : objMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			System.err.println("JsonUtil 转化对象为Json 失败！");
			return null;
		}
	}
	
	/**
	 *  JSON 字符串转化为对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToObject(String json, Class<T> T) {
		if(StringUtils.isEmpty(json) || T == null) return null;
		
		 try {
	            return T.equals(String.class) ? (T) json : objMapper.readValue(json,T);
	        } catch (IOException e) {
	            return null;
	        }
	}
}
