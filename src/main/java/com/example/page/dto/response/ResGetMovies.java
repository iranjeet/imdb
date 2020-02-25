package com.example.page.dto.response;

import java.util.List;

public class ResGetMovies {
	private Long id;
	private String name;
	private String releaseDate;
	private String language;

	private List<GetActor> actors;// SubClass
	private List<GetReview> reviews;//SubClass
	
	public List<GetReview> getReviews() {
		return reviews;
	}

	public void setReviews(List<GetReview> reviews) {
		this.reviews = reviews;
	}


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

	public static class GetActor {//get all actors
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
	
	public static class GetReview{//get review
		private Long id;
		private int stars;
		private String review;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public int getStars() {
			return stars;
		}
		public void setStars(int stars) {
			this.stars = stars;
		}
		public String getReview() {
			return review;
		}
		public void setReview(String review) {
			this.review = review;
		}
		
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
