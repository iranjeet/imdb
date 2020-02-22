package com.example.page.domain;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name= "director")
public class director {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "name", nullable =false)
	private String name;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dir", cascade = CascadeType.ALL)
    private Set<Movie> movies;
	
   public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Movie> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
