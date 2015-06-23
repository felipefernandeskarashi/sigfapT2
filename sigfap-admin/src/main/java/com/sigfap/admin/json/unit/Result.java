package com.sigfap.admin.json.unit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sigfap.admin.model.entity.Sector;
import com.sigfap.admin.model.entity.Unit;

public class Result implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 150326686167269736L;
	private String code;
    private List<Unit> unidades;
	
    public Result(){
		this.unidades = new ArrayList<Unit>();
		this.code = "SUCCESS";
	}
	
	public void setUnidades(List<Unit> set){
		this.unidades = set;
	}
	
	public List<Unit> getUnidades(){
		return this.unidades;
	}
	
}