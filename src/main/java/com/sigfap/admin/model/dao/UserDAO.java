package com.sigfap.admin.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;

import com.sigfap.admin.model.entity.User;

public class UserDAO extends HibernateDAO<User, Integer> {
	
	@Inject
	private static Logger log;
	/**
	 * Verifica a existência de email cadastrado
	 * 
	 * @param email
	 * @return TRUE se o login existe e FALSE caso contrário
	 */
	public boolean loginExists(String email) {
		return countByCriteria(Restrictions.like("email", email)) > 0;
	}

	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User authentication(String login, String password) throws Exception {
		List<User> user = findByCriteria(Restrictions.like("login", login));
		
		if (user.size() == 0)
			throw new Exception("user.notfound");

		if (user.get(0).getSenha().equals(DigestUtils.shaHex(password)))
			return user.get(0);
		
		
		return null;
	}
}
