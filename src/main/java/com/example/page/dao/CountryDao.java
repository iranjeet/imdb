package com.example.page.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.page.domain.Country;

@Repository
public class CountryDao {
	@PersistenceContext(name="application")
	EntityManager entityManager;
	
	public void create(Country country) {
		entityManager.persist(country);
		entityManager.flush();		
	}
	
	public void delete(Country country) {
		entityManager.clear();
		entityManager.flush();
	}
	
	public Country getById(Long id) {
		return entityManager.find(Country.class, id);
	}
	 @SuppressWarnings("unchecked")
	public List<Country> getAllCountry(){
		 return (List<Country>) entityManager.createQuery("from Country").getResultList();
	 }

}
