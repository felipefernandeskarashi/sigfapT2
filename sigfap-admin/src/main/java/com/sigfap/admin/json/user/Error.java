package com.sigfap.admin.json.user;

import java.io.Serializable;

public class Error implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private String message;
	
	public Error(String message){
		this.message = message;
		this.code = "ERROR";
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public String getCode(){
		return this.code;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
