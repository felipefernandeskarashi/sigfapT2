package com.sigfap.admin.json.fieldresearch;

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
	
	private Skill value;
	
    private List<Skill> areas;
    
    public Result() {
    	
    }
	
    public Result(Skill value){
    	super();
		this.code = "SUCCESS";
		this.value = value;
		this.areas = new ArrayList<Skill>();
	}
	
	public void setAreas(List<Skill> area){
		this.areas = area;
	}
	
	public List<Skill> getAreas(){
		return this.areas;
	}

	public Skill getValue() {
		return value;
	}

	public void setValue(Skill value) {
		this.value = value;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
