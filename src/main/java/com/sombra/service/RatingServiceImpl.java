package com.sombra.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sombra.dao.RatingDAO;
import com.sombra.model.Movie;
import com.sombra.model.Rating;

@Service
public class RatingServiceImpl implements RatingService{

	RatingDAO ratingDAO;
	
	public void setRatingDAO(RatingDAO ratingDAO) {
		this.ratingDAO = ratingDAO;
	}

	@Transactional
	@Override
	public void addRating(Rating rating) {
		
		ratingDAO.addRating(rating);
		
	}

	@Transactional
	@Override
	public void updateRating(Rating rating) {
		ratingDAO.updateRating(rating);
	}

	@Transactional
	@Override
	public List<Rating> listRatings() {

		return ratingDAO.listRatings();
	}

	@Transactional
	@Override
	public Rating getRatingById(int id) {
		
		return ratingDAO.getRatingById(id);
	}

	@Transactional
	@Override
	public void removeRating(int id) {
		
		ratingDAO.removeRating(id);
		
	}

	@Transactional
	@Override
	public List<Rating> getRatingsByValueOrderByDate(int id) {
		
		return ratingDAO.getRatingByValueOrderByDate(id);
	}

	@Transactional
	@Override
	public List<Movie> getMovies() {
		
		return ratingDAO.getMovies();
	}
	
	@Transactional
	@Override
	public List<Rating> getMovieUserRating() {
		
		return ratingDAO.getMovieUserRating();
	}

}
