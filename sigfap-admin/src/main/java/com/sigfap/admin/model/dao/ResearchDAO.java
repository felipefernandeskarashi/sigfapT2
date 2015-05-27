package com.sigfap.admin.model.dao;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.criterion.Restrictions;

import com.sigfap.admin.model.entity.Research;

public class ResearchDAO extends HibernateDAO<Research, Integer> {
	
	/**
	 * Verifica a existência de e-mail(login) cadastrado
	 * 
	 * @param login
	 * @return TRUE se o login existe e FALSE caso contrário
	 */
	public boolean loginExists(String email) {
		return countByCriteria(Restrictions.like("email", email)) > 0;
	}

	/**
	 * 
	 * @param login
	 * @param senha
	 * @return
	 * @throws Exception
	 */
	public Research authentication(String email, String senha) throws Exception {
		List<Research> research = findByCriteria(Restrictions.like("email",
				email));
		if (research.size() == 0)
			throw new Exception("research.notfound");
		if (research.get(0).getSenha().equals(DigestUtils.shaHex(senha)))
			return research.get(0);

		return null;
	}

}