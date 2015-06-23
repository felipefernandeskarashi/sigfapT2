package com.sigfap.admin.json.unit;

import java.io.Serializable;

public class Error implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4691040248699758910L;

	
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
	

}
