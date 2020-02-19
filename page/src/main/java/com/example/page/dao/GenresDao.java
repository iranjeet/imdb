package com.example.page.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.page.domain.Genres;
import com.example.page.domain.actor;

@Repository
public class GenresDao implements Serializable {
	
	@PersistenceContext(unitName = "application")
	EntityManager entityManager;
	
	public void create(Genres genres) {
		entityManager.persist(genres);
		entityManager.flush();
	}
	
	public Genres getById(Long id) {
		return entityManager.find(Genres.class,id);
	}


}
