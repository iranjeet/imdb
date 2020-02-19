package com.example.page.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.page.domain.actor;
import com.example.page.dto.response.ResGetActor;

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

	public void delete(actor act) {
		entityManager.remove(act);
		entityManager.flush();
	}

	public actor getById(Long id) {
		return entityManager.find(actor.class, id);
	}
	
	
	public List<actor> getAllActor(){
		return (List<actor>) entityManager.createQuery("from actor").getResultList();
	}

}
