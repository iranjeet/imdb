package com.example.page.domain;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.example.page.domain.AssnMovieReview;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(name = "release_date")
	private String releaseDate;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "language")
	private String language;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genres genres;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "director_id")
	private director dir;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "production_id")
	private production production;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.ALL)
	private Set<AssnActorMovie> actorMovies;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.ALL)
	private Set<AssnMovieReview> reviewMovie;

	public Set<AssnMovieReview> getReviewMovie() {
		return reviewMovie;
	}

	public void setReviewMovie(Set<AssnMovieReview> reviewMovie) {
		this.reviewMovie = reviewMovie;
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Genres getGenres() {
		return genres;
	}

	public void setGenres(Genres genres) {
		this.genres = genres;
	}

	public director getDir() {
		return dir;
	}

	public void setDir(director dir) {
		this.dir = dir;
	}

	public Set<AssnActorMovie> getActorMovies() {
		return actorMovies;
	}

	public void setActorMovies(Set<AssnActorMovie> actorMovies) {
		this.actorMovies = actorMovies;
	}

	public production getProduction() {
		return production;
	}

	public void setProduction(production production) {
		this.production = production;
	}

}