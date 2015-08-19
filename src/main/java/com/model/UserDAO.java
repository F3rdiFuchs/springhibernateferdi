package com.model;

import java.util.List;

public interface UserDAO {
	public void save(User _user);
	public List <User> list();
}
