package com.example.page.dto.response;

import java.util.List;

public class ResGetMovies {
	private Long id;
	private String name;
	private String releaseDate;
	private String language;

	private List<GetActor> actors;// SubClass
	private GetGenres genres;// SubClass

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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<GetActor> getActors() {
		return actors;
	}

	public void setActors(List<GetActor> actors) {
		this.actors = actors;
	}

	public GetGenres getGenres() {
		return genres;
	}

	public void setGenres(GetGenres genres) {
		this.genres = genres;
	}

	public static class GetActor {
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

	public static class GetGenres {
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

}

/*This for giving the movie list with movie name only not any other  functionality
 package com.example.page.dto.response;

import java.util.List;

public class ResGetMovies {
	private Long id;
	private String name;
	private String releaseDate;
	private String language;
	
	private List<String> actors;//SubClass
	private GetGenres genres;//SubClass

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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public GetGenres getGenres() {
		return genres;
	}

	public void setGenres(GetGenres genres) {
		this.genres = genres;
	}

	public static class GetActor {
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

	public static class GetGenres {
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

}


 * */
