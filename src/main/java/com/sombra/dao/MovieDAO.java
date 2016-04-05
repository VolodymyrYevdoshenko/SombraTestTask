package com.sombra.dao;

import java.util.List;

import com.sombra.model.Movie;

public interface MovieDAO {

	public void addMovie(Movie movie);
	public void updateMovie(Movie movie);
	public List<Movie> listMovies();
	public Movie getMovieById(int id);
	public void removeMovie(int id);
	public List<String> getMoviesWithNoRating();
}
