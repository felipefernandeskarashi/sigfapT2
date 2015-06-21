package com.sigfap.admin.json.research;

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
	
	private Research value;
	
    private List<Research> pesquisadores;
    
    public Result() {
    	this.code = "SUCCESS";
		this.pesquisadores = new ArrayList<Research>();
    }
	
    public Result(Research value){
    	super();
		this.code = "SUCCESS";
		this.value = value;
		this.pesquisadores = new ArrayList<Research>();
	}
	
	public void setPesquisadores(List<Research> pesquisador){
		this.pesquisadores = pesquisador;
	}
	
	public List<Research> getPesquisadores(){
		return this.pesquisadores;
	}

	public Research getValue() {
		return value;
	}

	public void setValue(Research value) {
		this.value = value;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
