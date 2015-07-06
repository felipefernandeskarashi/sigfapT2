package com.sigfap.admin.validation;

public class CheckTelefone {
	public CheckTelefone() {

	}
	
	public boolean isTelefone(String tel) {  
		  
	    String formato = "\\([0-9]{2}?\\)[0-9]{4}?\\-[0-9]{4}?";  
	      
	    if((tel == null) || (tel.length()!=13) || (!tel.matches(formato)))  
	        return false;  
	      
	    else  
	        return true;  
	} 
}
