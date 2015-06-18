package com.sigfap.admin.json.ethnicity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sigfap.admin.model.entity.Ethnicity;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private Ethnicity value;
	
	
	
	
	public Result(Ethnicity value) {
		super();
		this.code = "SUCESS";
		this.value = value;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Ethnicity getValue() {
		return value;
	}
	public void setValue(Ethnicity value) {
		this.value = value;
	}
	

}
