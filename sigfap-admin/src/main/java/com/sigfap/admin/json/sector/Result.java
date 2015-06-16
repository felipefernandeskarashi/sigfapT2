package com.sigfap.admin.json.sector;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sigfap.admin.model.entity.Sector;

public class Result implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 150326686167269736L;
	private String code;
    private List<Sector> setores;
	
    public Result(){
		this.setores = new ArrayList<Sector>();
		this.code = "SUCCESS";
	}
	
	public void setSetores(List<Sector> set){
		this.setores = set;
	}
	
	public List<Sector> getSetores(){
		return this.setores;
	}
	
}
