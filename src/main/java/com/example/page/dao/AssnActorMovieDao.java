package com.example.page.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.page.domain.AssnActorMovie;

@Repository
public class AssnActorMovieDao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8966500899619938690L;
	@PersistenceContext(unitName = "application")
	EntityManager entityManager;

	public void create(AssnActorMovie act) {
		entityManager.persist(act);
		entityManager.flush();
	}

	public void delete(AssnActorMovie act) {
		entityManager.remove(act);
		entityManager.flush();
	}

	public AssnActorMovie getById(Long id) {
		return entityManager.find(AssnActorMovie.class, id);
	}

}

