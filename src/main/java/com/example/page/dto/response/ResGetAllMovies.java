package com.example.page.dto.response;

import java.util.ArrayList;
import java.util.List;

public class ResGetAllMovies {
	List<ResGetAllMovies.ResGetAllMov> movies=new ArrayList<ResGetAllMovies.ResGetAllMov>();

	public List<ResGetAllMovies.ResGetAllMov> getMovies() {
		return movies;
	}
 
	public void setMovies(List<ResGetAllMovies.ResGetAllMov> movies) {
		this.movies = movies;
	}

	public static class ResGetAllMov {
		private long id;
		private String name;
		private String releaseDate;

		public String getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
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

}
