package com.csf.datamonitor.common.base;

import java.io.Serializable;

public class RespObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private String type;
	
	private Object message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
