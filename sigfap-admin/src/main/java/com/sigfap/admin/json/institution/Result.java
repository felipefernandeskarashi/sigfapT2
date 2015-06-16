package com.sigfap.admin.json.institution;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sigfap.admin.model.entity.Institution;
import com.sigfap.admin.model.entity.Sector;

public class Result implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
    private List<Institution> value;
	
    public Result(){
		this.value = new ArrayList<Institution>();
		this.code = "SUCCESS";
	}
	
    //Get e Set
    
    public String getCode() {
		return code;
	}
    
    public List<Institution> getValue() {
		return value;
	}
    
    public void setCode(String code) {
		this.code = code;
	}
    
    public void setValue(List<Institution> value) {
		this.value = value;
	}
	
}
