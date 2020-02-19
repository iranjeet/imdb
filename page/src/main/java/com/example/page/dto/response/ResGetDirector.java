package com.example.page.dto.response;

import java.util.List;
import java.util.Set;

import com.example.page.domain.Movie;

public class ResGetDirector {
	private long id;
	private String name;
	private List<GetMovies> movies;
	
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
	
	
	public List<GetMovies> getMovies() {
		return movies;
	}
	public void setMovies(List<GetMovies> movies) {
		this.movies = movies;
	}


	public static class GetMovies {
		
		private Long id;
		
		private String movieName;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getMovieName() {
			return movieName;
		}

		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}
	}
}
