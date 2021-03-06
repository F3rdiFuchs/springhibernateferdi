package com.service.UserService;

import java.util.List;

import com.model.User.User;
import com.model.User.UserDAO;

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


	public List<User> listUser() {
		return this.userDAO.listUser();
	}

	public void removeUser(Integer id) {
		this.userDAO.removeUser(id);
	}

	public boolean checkLogin(String userName, String passWord) {

		return this.userDAO.checkLogin(userName, passWord);
	}
}
