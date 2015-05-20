package com.sigfap.admin.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;

public class HibernateDAO<E, PK extends Serializable> implements
		IGenericDAO<E, PK> {

	private Class<E> persistentClass;

	@Inject
	private Logger log;

	@Inject
	@Corporate
	private Session session;

	@SuppressWarnings("unchecked")
	public HibernateDAO() {

		persistentClass = (Class<E>) ((ParameterizedType) (getClass()
				.getGenericSuperclass())).getActualTypeArguments()[0];
	}

	protected Session getSession() {
		return session;
	}

	@Override
	public void deleteById(PK id) {
		delete(findById(id, false));
	}

	@Override
	public Class<E> getEntityClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findById(PK id, boolean lock) {
		E entity;
		if (lock)
			entity = (E) getSession().get(getEntityClass(), id,
					LockOptions.UPGRADE);
		else
			entity = (E) getSession().get(getEntityClass(), id);

		return entity;
	}

	public E findById(PK id) {
		return findById(id, false);
	}

	@Override
	public List<E> findAll() {
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findByExample(E exampleInstance) {
		Criteria crit = getSession().createCriteria(getEntityClass());
		crit.add(Example.create(exampleInstance).ignoreCase().enableLike(MatchMode.ANYWHERE));
		return crit.list();
	}

	protected int countByCriteria(Criterion... criterion) {

		Criteria crit = getSession().createCriteria(getEntityClass());
		crit.setProjection(Projections.rowCount());

		for (final Criterion c : criterion)
			crit.add(c);

		return ((Long) crit.list().get(0)).intValue();
	}

	@Override
	public int countAll() {
		return countByCriteria();
	}

	@Override
	public int countByExample(E exampleInstance) {

		Criteria crit = getSession().createCriteria(getEntityClass());
		crit.setProjection(Projections.rowCount());
		crit.add(Example.create(exampleInstance));

		return  Integer.valueOf(crit.list().get(0).toString());
	}

	@Override
	public E persist(E entity) {
		Transaction tx = null;

		try {
			tx = getSession().beginTransaction();
			getSession().persist(entity);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return entity;
	}

	@Override
	public E update(E entity) {
		
		Transaction tx = null;

		try {
			tx = getSession().beginTransaction();
			getSession().merge(entity);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return entity;
	}

	@Override
	public void delete(E entity) {
		Transaction tx = null;

		try {
			tx = getSession().beginTransaction();
			getSession().delete(entity);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<E> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getEntityClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByCriteriaPageByPage(int firstResult, int maxResults,
			Criterion... criterion) {
		Criteria criteria = getSession().createCriteria(getEntityClass());

		for (Criterion c : criterion)
			criteria.add(c);

		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);

		return criteria.list();
	}
}
