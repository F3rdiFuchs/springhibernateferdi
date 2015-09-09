package com.model.User;

import java.util.List;

public interface UserDAO {
	public List <User> listUser();
	public void addUser(User user);
	public void removeUser(Integer userId);
	public boolean checkLogin(String userName, String passWord);
}
