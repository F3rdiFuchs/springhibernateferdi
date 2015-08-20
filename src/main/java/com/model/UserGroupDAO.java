package com.model;

import java.util.HashSet;

public interface UserGroupDAO {
	public void save(UserGroup _userGroup);
	public HashSet <UserGroup> list();
}
