package com.model.Tasks;

import java.util.List;

public interface TasksDAO {
	public void addTasks(Tasks task);
	public List <Tasks> listTasks();
}
