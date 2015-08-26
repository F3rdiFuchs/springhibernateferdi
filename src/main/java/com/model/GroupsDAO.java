package com.model;

import java.util.List;

public interface GroupsDAO {
	public List <Groups> listGroups();
	public List<User> listUserInGroup(Integer userid);
	public void addGroup(Groups group);
	public void removeGroup(Integer group);
	public void updateGroup(Groups group);	
}
