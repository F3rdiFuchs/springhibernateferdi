package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	public void addUser(User user);
	public List<User> listUser();
	public void removeUser(Integer id); 
}
