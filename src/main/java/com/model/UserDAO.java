package com.model;

import java.util.List;
import com.model.User;

public interface UserDAO {
	public List <User> listUser();
	public void addUser(User user);
	public void removeUser(Integer userId);
}
