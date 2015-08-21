package com.model;

import java.util.List;

public interface GroupsDAO {
	public void addGroup(Groups _group);
	public void updateGroup(Groups _group);
	public List <Groups> listGroups();
	public void removeGroup(int _group);
}
