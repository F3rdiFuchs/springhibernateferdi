package com.service.GroupService;

import java.util.List;

import com.model.Groups.Groups;
import com.model.Groups.GroupsDAO;
import com.model.User.User;

public class GroupsServiceImpl implements GroupsService {
	private GroupsDAO groupsDAO;
	
	public void addGroup(Groups _group) {
		this.groupsDAO.addGroup(_group);
	}

	public void updateGroup(Groups _group) {
		this.groupsDAO.updateGroup(_group);
	}

	public List<Groups> listGroup() {
		return this.groupsDAO.listGroups();
	}

	public GroupsDAO getGroupsDAO() {
		return groupsDAO;
	}

	public void setGroupsDAO(GroupsDAO groupsDAO) {
		this.groupsDAO = groupsDAO;
	}

	public void removeGroups(int _id) {
		this.groupsDAO.removeGroup(_id);
	}
}
