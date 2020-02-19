package com.example.page.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.page.domain.Genres;
import com.example.page.domain.actor;
import com.example.page.domain.director;

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


	public List<Genres> getAllGeneres() {
		// TODO Auto-generated method stub
		return  (List<Genres>)  entityManager.createQuery("from Genres").getResultList();
	}


}
