package com.service;

import java.util.List;
import com.model.User;
import com.model.UserDAO;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void addUser(User p) {
		this.userDAO.addUser(p);
	}

	public void updateUser(User p) {
		this.userDAO.updateUser(p);
		
	}

	public List<User> listUser() {
		return this.userDAO.listUser();
	}

	public void removeUser(int id) {
		this.userDAO.removeUser(id);
	}
	

}
