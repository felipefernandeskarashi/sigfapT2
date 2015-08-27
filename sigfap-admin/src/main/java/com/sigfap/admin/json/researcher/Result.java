package com.sigfap.admin.json.researcher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sigfap.admin.model.entity.Research;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private List<Research> value;
	
	public Result() {
		this.code = "SUCCESS";
		this.value = new ArrayList<Research>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Research> getValue() {
		return value;
	}

	public void setValue(List<Research> value) {
		this.value = value;
	}
	
}
