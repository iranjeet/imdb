package com.example.page.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.page.domain.director;
import com.example.page.dto.response.ResGetDirector;

@Repository
public class directorDao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2489277769730482748L;
	@PersistenceContext(unitName = "application")
	EntityManager entityManager;
	
	public void create(director dir) {
		entityManager.persist(dir);
		entityManager.flush();
	}
	
	public void delete(director dir	) {
		entityManager.remove(dir);
		entityManager.flush();
	}
	
	public director getById(Long id) {
		return entityManager.find(director.class,id);
	}
	@SuppressWarnings("unchecked")
	public List<director> getAllDirector() {
			return (List<director>) entityManager.createQuery("from director").getResultList();
	}

}
