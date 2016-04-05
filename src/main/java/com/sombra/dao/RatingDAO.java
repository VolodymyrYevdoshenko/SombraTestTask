package com.sombra.dao;

import java.util.List;

import com.sombra.model.Movie;
import com.sombra.model.Rating;

public interface RatingDAO {

	public void addRating(Rating rating);
	public void updateRating(Rating rating);
	public List<Rating> listRatings();
	public Rating getRatingById(int id);
	public void removeRating(int id);
	public List<Rating> getRatingByValueOrderByDate(int id);
	public List<Movie> getMovies();
	public List<Rating> getMovieUserRating();
}
