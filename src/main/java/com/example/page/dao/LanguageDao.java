package com.example.page.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.page.domain.Language;

@SuppressWarnings("serial")
@Repository
public class LanguageDao implements Serializable {
	
	@PersistenceContext(unitName="application")
	EntityManager entityManager;
	
	public void create(Language lang) {
		entityManager.persist(lang);
		entityManager.flush();
	}
	public void delete(Language lang) {
		entityManager.remove(lang);
		entityManager.flush();
	}
	public Language getById(Long id) {
		return entityManager.find(Language.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Language> getAllLanguage() {
		return (List<Language>) entityManager.createQuery("from Language").getResultList();		
	}
	

}
