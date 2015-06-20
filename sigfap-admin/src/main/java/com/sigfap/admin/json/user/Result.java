package com.sigfap.admin.json.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sigfap.admin.model.entity.User;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private User value;
	
    private List<User> usuarios;
    
    public Result() {
    	
    }
	
    public Result(User value){
    	super();
		this.code = "SUCCESS";
		this.value = value;
		this.usuarios = new ArrayList<User>();
	}
	
	public void setUsuarios(List<User> usuario){
		this.usuarios = usuario;
	}
	
	public List<User> getUsuarios(){
		return this.usuarios;
	}

	public User getValue() {
		return value;
	}

	public void setValue(User value) {
		this.value = value;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
