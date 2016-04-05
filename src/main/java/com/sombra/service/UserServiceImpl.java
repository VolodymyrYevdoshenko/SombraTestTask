package com.sombra.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sombra.dao.UserDAO;
import com.sombra.model.User;

@Service
public class UserServiceImpl implements UserService{

	UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	@Override
	public void addUser(User user) {
		
		userDAO.addUser(user);
		
	}

	@Transactional
	@Override
	public void updateUser(User user) {
		
		userDAO.updateUser(user);
		
	}

	@Transactional
	@Override
	public List<User> listUsers() {
		
		return userDAO.listUsers();
	}

	@Transactional
	@Override
	public User getUserById(int id) {
		
		return userDAO.getUserById(id);
	}

	@Transactional
	@Override
	public void removeUser(int id) {
		
		userDAO.removeUser(id);
		
	}

}
