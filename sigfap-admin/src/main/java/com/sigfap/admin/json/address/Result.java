package com.sigfap.admin.json.address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sigfap.admin.model.entity.Address;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private List<Address> value;
	
	public Result() {
		super();
		this.code = "SUCESS";
		this.value = new ArrayList<Address>();
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Address> getValue() {
		return value;
	}
	public void setValue(List<Address> value) {
		this.value = value;
	}
	
}
