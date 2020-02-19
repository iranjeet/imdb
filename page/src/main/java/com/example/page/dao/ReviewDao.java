package com.example.page.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.page.domain.Review;

@Repository
public class ReviewDao implements Serializable {

	@PersistenceContext(unitName = "application")
	EntityManager entityManager;

	public void create(Review review) {
		entityManager.persist(review);
		entityManager.flush();
	}

	public  Review getById(Long id) {
		return entityManager.find(Review.class, id);
	}

}
