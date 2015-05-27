package com.sigfap.admin.model.dao;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.criterion.Restrictions;

import com.sigfap.admin.model.entity.User;

public class UserDAO extends HibernateDAO<User, Integer> {
	
	/**
	 * Verifica a existência de e-mail(login) cadastrado
	 * 
	 * @param login
	 * @return TRUE se o login existe e FALSE caso contrário
	 */
	public boolean loginExists(String login) {
		return countByCriteria(Restrictions.like("login", login)) > 0;
	}

	/**
	 * 
	 * @param login
	 * @param senha
	 * @return
	 * @throws Exception
	 */
	public User authentication(String login, String senha) throws Exception {
		List<User> user = findByCriteria(Restrictions.like("login", login));
		if (user.size() == 0)
			throw new Exception("user.notfound");
		if (user.get(0).getSenha().equals(DigestUtils.shaHex(senha)))
			return user.get(0);
		
		
		return null;
	}
}
