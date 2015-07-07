package com.sigfap.admin.validation;

public class CheckRg {
	public CheckRg() {

	}

	/**
	 * Obs.: Somente números: 123456789
	 * @author Thalita
	 * @param RG
	 * @return boolean
	 */
	public boolean isRg(String RG) {
		// considera-se erro RG's formados por uma sequencia de numeros iguais
		if ((RG.equals("000000000") || RG.equals("111111111")
				|| RG.equals("222222222") || RG.equals("333333333")
				|| RG.equals("444444444") || RG.equals("555555555")
				|| RG.equals("666666666") || RG.equals("777777777")
				|| RG.equals("888888888") || RG.equals("999999999") || (RG
					.length() < 9))) {
			return false;
		} else {
			return true;
		}
	}
}
