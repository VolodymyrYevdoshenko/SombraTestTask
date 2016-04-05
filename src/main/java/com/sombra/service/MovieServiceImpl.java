package com.sombra.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sombra.dao.MovieDAO;
import com.sombra.model.Movie;

@Service
public class MovieServiceImpl implements MovieService{
	
	MovieDAO movieDAO;
	
	public void setMovieDAO(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	@Transactional
	@Override
	public void addMovie(Movie movie) {
	
		movieDAO.addMovie(movie);
		
	}

	@Transactional
	@Override
	public void updateMovie(Movie movie) {
		
		movieDAO.updateMovie(movie);
	}

	@Transactional
	@Override
	public List<Movie> listMovies() {
		
		return movieDAO.listMovies();
	}
	
	@Transactional
	@Override
	public Movie getMovieById(int id) {
		
		return movieDAO.getMovieById(id);
	}

	@Transactional
	@Override
	public void removeMovie(int id) {
		
		movieDAO.removeMovie(id);
		
	}
	

}
