package com.example.page.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.page.domain.actor;

@Repository
public class actorDao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8966500899619938690L;
	@PersistenceContext(unitName = "application")
	EntityManager entityManager;

	public void create(actor act) {
		entityManager.persist(act);
		entityManager.flush();
	}
	
	public void update(actor act) {
		entityManager.persist(act);
		entityManager.flush();
	}

	public void delete(Long id) {
	actor act=entityManager.find(actor.class,id);
    entityManager.remove(act);
   	entityManager.flush();
   	//entityManager.getTransaction().begin();
  	//entityManager.getTransaction().commit();
	}
	

	public actor getById(Long id) {
		return entityManager.find(actor.class, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<actor> getAllActor(){
		return (List<actor>) entityManager.createQuery("from actor").getResultList();
	}

}
