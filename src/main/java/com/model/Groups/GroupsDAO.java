package com.model.Groups;

import java.util.List;

public interface GroupsDAO {
	public List <Groups> listGroups();
	
	public void addGroup(Groups group);
	public void removeGroup(Integer group);
	public void updateGroup(Groups group);	
}
