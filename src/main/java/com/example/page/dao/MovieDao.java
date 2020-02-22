package com.example.page.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.example.page.domain.Movie;
import com.example.page.domain.director;

@Repository
public class MovieDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "application")
	EntityManager entityManager;
	
	public void create(Movie movie) {
		entityManager.persist(movie);
		entityManager.flush();
	}
	
	public void delete(Long id) {
		Movie movie=entityManager.find(Movie.class, id);
		entityManager.remove(movie);
		entityManager.flush();
	}

	
	public Movie getById(Long id) {
		return entityManager.find(Movie.class,id);
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Movie> getAllMovies() {
//		return (List<Movie>) entityManager.createQuery("from Movie c where c.id = :id").setParameter("id", id).getResultList();
//	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovies() {
		return (List<Movie>) entityManager.createQuery("from Movie").getResultList();
	}
}
