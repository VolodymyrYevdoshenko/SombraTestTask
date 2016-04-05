package com.sombra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sombra.service.*;
import com.sombra.model.*;

@Controller
@ResponseBody
public class RestController {

	MovieService movieService;
	
	UserService userService;
	
	RatingService ratingService;
	

    @Autowired(required=true)
    @Qualifier(value="movieService")
	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}

    @Autowired(required=true)
    @Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


    @Autowired(required=true)
    @Qualifier(value="ratingService")
	public void setRatingService(RatingService ratingService) {
		this.ratingService = ratingService;
	}

	@RequestMapping(value="/task0movies", method = RequestMethod.GET)
	public List<Movie> getAllMovies(){
		
	List<Movie> moviesList = movieService.listMovies();

	return moviesList; 
	}
	
	@RequestMapping(value="/task0users", method = RequestMethod.GET)
	public List<User> getAllUser(){
		
	List<User> usersList = userService.listUsers();

	return usersList; 
	}
	
	@RequestMapping(value="/task0ratings", method = RequestMethod.GET)
	public List<Rating> getAllRatings(){
		
	List<Rating> ratingsList = ratingService.listRatings();

	return ratingsList; 
	}
	
	@RequestMapping(value="/task1", method = RequestMethod.GET)
	public List<Rating> getTaskOne(){
		
		List<Rating> ratingList = ratingService.listRatings();
		
		for(Rating rating : ratingList){
			if(rating.getRatingDate() == null){
				rating.setRatingDate(new java.sql.Date(new java.util.Date().getTime()));
				ratingService.updateRating(rating);
			}
		}
		
		return ratingList;
	}
	
	@RequestMapping(value="/task2", method = RequestMethod.GET)
	public List<Movie> getTaskTwo(){
		
		movieService.addMovie(new Movie(9, "Deadpool", "Tim Miller"));
		movieService.addMovie(new Movie(10, "The 300 spartans", "Zak Snyder"));
		return movieService.listMovies();
	}
	
	@RequestMapping(value="/task3", method = RequestMethod.GET)
	public List<Rating> getTaskThree(){
		
		List<Rating> ratingList = ratingService.getRatingsByValueOrderByDate(4);
		ratingList.addAll(ratingService.getRatingsByValueOrderByDate(5));
		
		return ratingList;
	}
	
	@RequestMapping(value="/task4", method = RequestMethod.GET)
	public List<String> getTaskFour(){
		
		List<Movie> moviesList = movieService.listMovies();
		List<Movie> moviesWithRating = ratingService.getMovies();
		List<Integer> idOfMoviesWithRating = new ArrayList<Integer>(); 
		List<String> titlesList = new ArrayList<String>();
		
		for(Movie movie : moviesWithRating){
			idOfMoviesWithRating.add(movie.getId());
		}
		for(Movie movie : moviesList){
			if(!idOfMoviesWithRating.contains(movie.getId())){
				titlesList.add(movie.getTitle());
			}
		}
		
		return titlesList;
	}
	
	@RequestMapping(value="/task5", method = RequestMethod.GET)
	public List<Movie> getTaskFive(){
		movieService.removeMovie(9);
		movieService.removeMovie(10);
		return movieService.listMovies();
	}
	
	@RequestMapping(value="/task6", method = RequestMethod.GET)
	public List<Rating> getTaskSix(){
		
		return ratingService.getMovieUserRating();
	}
	
	
}
