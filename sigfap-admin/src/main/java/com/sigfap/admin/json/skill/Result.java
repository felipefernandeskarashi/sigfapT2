package com.sigfap.admin.json.skill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sigfap.admin.model.entity.Skill;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private List<Skill> value;
	
    public Result() {
    	this.code = "SUCCESS";
    	this.value = new ArrayList<Skill>();
    }
	
	public List<Skill> getValue() {
		return value;
	}

	public void setValue(List<Skill> value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
