package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	public void addUser(User p);
    public void updateUser(User p);
    public List<User> listUser();
    public List<User> listUserbyId(int _id);
    public void removeUser(int id);
}
