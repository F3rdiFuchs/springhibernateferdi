package com.model;

import java.util.HashSet;

public class UserGroup {
	private Integer groupId;
	private String name;
	private String description;
	private Integer accessLevel;
	
	private HashSet<User> employee = new HashSet<User>();
	
	public HashSet<User> getEmployee() {
		return employee;
	}
	public void setEmployee(HashSet<User> employee) {
		this.employee = employee;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}
}
