package com.model;

import java.util.HashSet;

public interface TaskDAO {
	public void save(Task _task);
	public HashSet <User> list();
}
