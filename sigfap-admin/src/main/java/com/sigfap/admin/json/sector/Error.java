package com.sigfap.admin.json.sector;

import java.io.Serializable;

public class Error implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4089810544347907115L;
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
