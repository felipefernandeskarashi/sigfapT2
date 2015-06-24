package com.sigfap.admin.json.telephone;

import java.io.Serializable;

public class Error implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Error() {
		// TODO Auto-generated constructor stub
	}
	
	private String code;
	private String message;
	
	public Error(String message) {
		this.code = "ERROR";
		this.message = message;
	}

	
	//Get e Set
	
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
	
}
