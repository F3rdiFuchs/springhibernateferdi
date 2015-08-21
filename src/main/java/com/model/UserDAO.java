package com.model;

import java.util.List;
import com.model.User;

public interface UserDAO {
	public void addUser(User _user);
	public void updateUser(User _user);
	public List <User> listUser();
	public void removeUser(int _userId);
}
