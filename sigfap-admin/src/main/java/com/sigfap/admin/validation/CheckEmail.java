package com.sigfap.admin.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import javax.validation.constraints.Pattern;

public class CheckEmail {
	public CheckEmail() {

	}

	/**
	 * Obs.: Retirado do site http://www.guj.com.br/8002-validacao-de-email
	 * @param email
	 * @return boolean
	 */
	public boolean isEmail(String email) {
		if ((email == null) || (email.trim().length() == 0)) {
			return false;
		} else {
			String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
			Pattern pattern = Pattern.compile(emailPattern,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();
		}
	}
}
