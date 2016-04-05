package com.sombra.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sombra.model.Movie;
import com.sombra.model.Rating;

@Repository
public class RatingDAOImpl implements RatingDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	Session session = null;
	
	@Override
	public void addRating(Rating rating) {
		
		session = sessionFactory.getCurrentSession();
		session.persist(rating);
		
	}

	@Override
	public void updateRating(Rating rating) {
		
		session = sessionFactory.getCurrentSession();
		session.update(rating);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rating> listRatings() {
		
		session = sessionFactory.getCurrentSession();
		List<Rating> ratingList = session.createQuery("from Rating").list();
		return ratingList;
	}

	@Override
	public Rating getRatingById(int id) {
		
		session = sessionFactory.getCurrentSession();
		
		Rating rating = (Rating) session.load(Rating.class, new Integer(id));
		
		return rating;
	}

	@Override
	public void removeRating(int id) {
		
		session = sessionFactory.getCurrentSession();
		
		Rating rating  = (Rating) session.load(Rating.class, new Integer(id));
		
		if(rating != null){
			session.delete(rating);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rating> getRatingByValueOrderByDate(int rating) {

		session = sessionFactory.getCurrentSession();
		
		List<Rating> ratingList = session.createQuery("select r.movie.id, r.ratingDate from Rating r where r.rating = " + rating + "  order by r.ratingDate").list();
		
		return ratingList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getMovies() {
		
		
		session = sessionFactory.getCurrentSession();
		
		List<Movie> movieList = session.createQuery("select r.movie from Rating r").list();
		
		return movieList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rating> getMovieUserRating() {
		
		session = sessionFactory.getCurrentSession();
		
		List<Rating> ratingList = session.createQuery("select r.movie.title, r.user.name, r.rating from Rating r").list();
		return ratingList;
	}

}
