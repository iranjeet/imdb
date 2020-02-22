package com.example.page.dto.response;

import java.util.List;

import com.example.page.dto.response.ResGetDirector.GetMovies;

public class ResGetGeneres {
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

	public static class GetMovie {

		private Long id;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getGenresName() {
			return GenresName;
		}

		public void setGenresName(String genresName) {
			GenresName = genresName;
		}

		private String GenresName;

	}

}
