package com.model;

import java.util.List;

public interface TasksDAO {
	public void save(Tasks _task);
	public List <Tasks> listTasks();
}
