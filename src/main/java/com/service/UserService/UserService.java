package com.service.UserService;

import java.util.List;

import com.model.User.User;

public interface UserService {
	public void addUser(User user);
	public List<User> listUser();
	public void removeUser(Integer id); 
	public boolean checkLogin(String userName, String passWord);
}
