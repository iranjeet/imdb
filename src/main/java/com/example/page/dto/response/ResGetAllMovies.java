package com.example.page.dto.response;

import java.util.ArrayList;
import java.util.List;

public class ResGetAllMovies {
	
	List<ResGetAllMovies.ResGetAllMov> movies = new ArrayList<ResGetAllMovies.ResGetAllMov>();

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
		private String language;
		private String genres;
		
		public String getGenres() {
			return genres;
		}

		public void setGenres(String genres) {
			this.genres = genres;
		}

		private List<GetAllActor> actors = new ArrayList<ResGetAllMovies.ResGetAllMov.GetAllActor>();

		public List<GetAllActor> getActors() {
			return actors;
		}

		public void setActors(List<GetAllActor> actors) {
			this.actors = actors;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}
		public static class GetGenres {//Get all genrrics
			private Long id;
			private String name;

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

		}


		public static class GetAllActor {
			private Long id;
			private String name;

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
		}

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
