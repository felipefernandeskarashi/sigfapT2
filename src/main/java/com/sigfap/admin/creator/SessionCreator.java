package com.sigfap.admin.creator;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sigfap.admin.model.dao.Corporate;



public class SessionCreator {

	private static final Logger LOGGER = LoggerFactory.getLogger(SessionCreator.class);
	private SessionFactory factory;

	/**
	 * @deprecated CDI eyes only
	 */
	public SessionCreator() {
	}

	@Inject
	public SessionCreator(@Corporate SessionFactory factory) {
		this.factory = factory;
	}

	@Produces
	@RequestScoped
	@Corporate
	public Session getInstance() {
		Session session = factory.openSession();
		LOGGER.debug("opening a session {}", session);
		return session;
	}

	public void destroy(@Corporate @Disposes Session session) {
		LOGGER.debug("closing session {}", session);
		session.close();
	}
}