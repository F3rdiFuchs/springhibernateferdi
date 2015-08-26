package com.model;

import java.util.List;
import com.model.User;

public interface UserDAO {
	public List <User> listUser();
	public List <User> listUserByGroupId(int groupId);
	public void addUser(User user);
	public void removeUser(Integer userId);
	
	public void updateUser(User user);
	
	
}
