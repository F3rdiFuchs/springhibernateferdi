package com.model;

import java.util.List;
import com.model.User;

public interface UserDAO {
	public void save(User _user);
	public List <User> list();
}
