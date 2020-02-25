package com.example.page.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Assn_Actor_Movie")
public class AssnActorMovie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	@ManyToOne
	@JoinColumn(name = "actor_id")
	private actor actor;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	@JoinColumn(name="isActive")
	private Boolean isActive;
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public actor getActor() {
		return actor;
	}

	public void setActor(actor actor) {
		this.actor = actor;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
