package com.sombra.service;

import java.util.List;

import com.sombra.model.Movie;

public interface MovieService {

	public void addMovie(Movie movie);
	public void updateMovie(Movie movie);
	public List<Movie> listMovies();
	public Movie getMovieById(int id);
	public void removeMovie(int id);
}
