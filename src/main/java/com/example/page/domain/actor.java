package com.example.page.domain;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name= "actor")
public class actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genres", cascade = CascadeType.ALL)
	private Set<Movie> movies;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "actor", cascade = CascadeType.ALL)
	private Set<AssnActorMovie> actorMovies;
    

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
