package com.sombra.service;

import java.util.List;

import com.sombra.model.Movie;
import com.sombra.model.Rating;

public interface RatingService {

	public void addRating(Rating rating);
	public void updateRating(Rating rating);
	public List<Rating> listRatings();
	public Rating getRatingById(int id);
	public void removeRating(int id);
	public List<Rating> getRatingsByValueOrderByDate(int id);
	public List<Movie> getMovies();
	public List<Rating> getMovieUserRating();
}
