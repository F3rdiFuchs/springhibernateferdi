package com.service;

import java.util.List;

import com.model.Groups;
import com.model.User;

public interface GroupsService {
	public void addGroup(Groups p);
    public void updateGroup(Groups p);
    public List<Groups> listGroup();
    public void removeGroups(int id);
}
