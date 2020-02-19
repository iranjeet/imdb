package com.example.page.dto.request;

import java.util.Set;

import com.example.page.domain.Movie;

public class ReqAddDirector {
	private String name;
	private Set<Movie> movie;

	

	public Set<Movie> getMovie() {
		return movie;
	}

	public void setMovie(Set<Movie> movie) {
		this.movie = movie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
