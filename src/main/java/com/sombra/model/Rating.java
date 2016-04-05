package com.sombra.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "rating")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Rating implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "movieId", referencedColumnName="id")
	private Movie movie;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "userId", referencedColumnName="id")	
	private User user;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "ratingDate")
	private Date ratingDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getRatingDate() {
		return ratingDate;
	}

	public void setRatingDate(Date ratingDate) {
		this.ratingDate = ratingDate;
	}
	
	
}
