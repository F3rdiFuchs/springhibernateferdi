package com.model;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Groups {
	private Integer groupId;
	private String name;
	private String description;
	private Integer accessLevel;
	public Set<User> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<User> employee) {
		this.employee = employee;
	}
	private Set<User> employee = new HashSet<User>();
	
	
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
