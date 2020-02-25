package com.example.page.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.example.page.domain.Movie;
import com.example.page.domain.Review;

@Entity
@Table(name = "Assn_Review_Movie")
public class AssnMovieReview {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name="review_id")
	private Review review;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
}
