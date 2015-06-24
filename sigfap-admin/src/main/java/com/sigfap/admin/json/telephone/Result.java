package com.sigfap.admin.json.telephone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sigfap.admin.model.entity.Telephone;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private List<Telephone> value;
	
	public Result() {
		super();
		this.code = "SUCESS";
		this.value = new ArrayList<Telephone>();
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Telephone> getValue() {
		return value;
	}
	public void setValue(List<Telephone> value) {
		this.value = value;
	}
	
}
