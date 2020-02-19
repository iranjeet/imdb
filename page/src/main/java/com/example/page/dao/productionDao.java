package com.example.page.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;

import com.example.page.domain.production;
import com.example.page.dto.response.ResGetProduction;

@Repository
public class productionDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7826122580623686748L;
	@PersistenceContext(unitName = "application")
	EntityManager entityManager;
	
	public void create(production pro) {
		entityManager.persist(pro);
		entityManager.flush();
	}
	
	public void delete(production pro) {
		entityManager.remove(pro);
		entityManager.flush();
	}
	public production getById(Long id) {
		return entityManager.find(production.class,id);
	}

	public List<production> getAllProduction() {
		// TODO Auto-generated method stub
		return (List<production>) entityManager.createQuery("from production").getResultList();
	}
	
	

}
