package com.sigfap.admin.json.representative;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sigfap.admin.model.entity.Representative;
import com.sigfap.admin.model.entity.Sector;

public class Result implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 150326686167269736L;
	private String code;
    private List<Representative> representantes;
	
    public Result(){
		this.representantes = new ArrayList<Representative>();
		this.code = "SUCCESS";
	}
	
	public void setRepresentantes(List<Representative> set){
		this.representantes = set;
	}
	
	public List<Representative> getRepresentantes(){
		return this.representantes;
	}
	
}
