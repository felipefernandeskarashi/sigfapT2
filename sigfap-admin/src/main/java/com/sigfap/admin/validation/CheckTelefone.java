package com.sigfap.admin.validation;

public class CheckTelefone {
	public CheckTelefone() {

	}
	
	/**
	 * Obs.: Exemplo: (67)3321-4567 ou (67)9913-1289 ou (11)99123-4510
	 * @author Thalita
	 * @param tel
	 * @return boolean
	 */
	public boolean isTelefone(String telefone) {  
		  
	    String formato = "\\([0-9]{2}?\\)[0-9]{5}?\\-[0-9]{4}?";  
	      
	    if((telefone == null) || (telefone.length() < 13) || (telefone.length() > 14) || (!telefone.matches(formato)))  
	        return false;  
	      
	    else  
	        return true;  
	} 
}
