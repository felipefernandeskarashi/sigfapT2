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
	
	private List<Research> value;
	
<<<<<<< HEAD
    public Result() {
    	this.code = "SUCCESS";
		this.value = new ArrayList<Research>();
    }
	
	public List<Research> getValue() {
		return value;
	}

	public void setValue(List<Research> value) {
		this.value = value;
	}

=======
    public Result(){
    	super();
		this.code = "SUCCESS";
		this.value = new ArrayList<Research>();
	}
    
    public List<Research> getValue() {
		return value;
	}
    
    public void setValue(List<Research> value) {
		this.value = value;
	}
    
>>>>>>> c989b65612bfd7473a1452751b334ed4bdf3f12d
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
