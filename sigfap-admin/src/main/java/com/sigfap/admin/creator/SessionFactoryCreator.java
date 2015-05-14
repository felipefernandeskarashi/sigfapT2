package com.sigfap.admin.creator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sigfap.admin.model.dao.Corporate;


public class SessionFactoryCreator {

	private static final Logger LOGGER = LoggerFactory.getLogger(SessionFactoryCreator.class);
	private Configuration cfg;
	private ServiceRegistry serviceRegistry;

	/**
	 * @deprecated CDI eyes only
	 */
	public SessionFactoryCreator() {
	}

	@Inject
	public SessionFactoryCreator(Configuration cfg, ServiceRegistry serviceRegistry) {
		this.cfg = cfg;
		this.serviceRegistry = serviceRegistry;
	}

	@Produces
	@ApplicationScoped
	@Corporate
	public SessionFactory getInstance() {
		LOGGER.debug("creating a session factory");
		return cfg.buildSessionFactory(serviceRegistry);
	}

	public void destroy(@Corporate @Disposes SessionFactory sessionFactory) {
		LOGGER.debug("destroying session factory");
		sessionFactory.close();
	}
}