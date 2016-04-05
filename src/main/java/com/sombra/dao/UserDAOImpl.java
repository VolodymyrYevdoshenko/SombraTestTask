package com.sombra.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sombra.model.User;

@Repository
public class UserDAOImpl implements UserDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	Session session = null;
	
	@Override
	public void addUser(User user) {
		
		session = sessionFactory.getCurrentSession();
		session.persist(user);
		
	}

	@Override
	public void updateUser(User user) {
		
		session = sessionFactory.getCurrentSession();
		session.update(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		
		session = sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User").list();
		return usersList;
		
	}

	@Override
	public User getUserById(int id) {
		session = sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));
		return user;
	}

	@Override
	public void removeUser(int id) {
		session = sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));
		if(user != null){
			session.delete(user);
		}
	}

}
