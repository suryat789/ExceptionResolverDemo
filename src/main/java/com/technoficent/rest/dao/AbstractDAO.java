package com.technoficent.rest.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO {

	@Autowired
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void persist(Object entity) {
		getEntityManager().persist(entity);
	}

	public void delete(Object entity) {
		getEntityManager().remove(entity);
	}
}
