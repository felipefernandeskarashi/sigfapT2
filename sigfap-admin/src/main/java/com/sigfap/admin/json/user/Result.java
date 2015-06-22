package com.sigfap.admin.json.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sigfap.admin.model.entity.User;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private List<User> value;
	
    public Result() {
    	this.code = "SUCCESS";
    	this.value = new ArrayList<User>();
    }
	
	public List<User> getValue() {
		return value;
	}

	public void setValue(List<User> value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
