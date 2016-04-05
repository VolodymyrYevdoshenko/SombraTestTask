package com.sombra.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sombra.model.Movie;

@Repository
@Transactional
public class MovieDAOImpl implements MovieDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session session = null;
	
	@Override
	public void addMovie(Movie movie){
		session = sessionFactory.getCurrentSession();
		session.persist(movie);
	}
	
	@Override
	public void updateMovie(Movie movie){
		session = sessionFactory.getCurrentSession();
		session.update(movie);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> listMovies(){
		session = sessionFactory.getCurrentSession();
		List<Movie> moviesList = session.createQuery("from Movie").list();
		return moviesList;
	}
	
	@Override
	public Movie getMovieById(int id){
		session = sessionFactory.getCurrentSession();
		Movie movie = (Movie) session.load(Movie.class, new Integer(id));
		return movie;
	}
	
	@Override
	public void removeMovie(int id){
		session = sessionFactory.getCurrentSession();
		Movie movie = (Movie) session.load(Movie.class, new Integer(id));
		if(movie != null){
			session.delete(movie);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getMoviesWithNoRating() {
		
		session = sessionFactory.getCurrentSession();
		
		List<String> titlesList = session.createQuery("select m.title from Movie m left join Rating r on m.id = r.movie.id where r.rating = null ").list();
		
		return titlesList;
	}
}

