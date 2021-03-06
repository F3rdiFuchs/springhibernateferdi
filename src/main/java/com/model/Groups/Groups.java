package com.model.Groups;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.model.User.User;

@Entity
@Table(name="GROUPS")
public class Groups {
	@Id
    @Column(name="groupId")
	private Integer groupId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="accessLevel")
	private Integer accessLevel;
	
	@Column(name="allowToLogin")
	private Boolean allowToLogin;
	
	@OneToMany(mappedBy = "groups")
	private List<User> user;

	
	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
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

	public Boolean getAllowToLogin() {
		return allowToLogin;
	}

	public void setAllowToLogin(Boolean allowToLogin) {
		this.allowToLogin = allowToLogin;
	}
}
