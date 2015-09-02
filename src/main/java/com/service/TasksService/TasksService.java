package com.service.TasksService;

import java.util.List;

import com.model.Tasks.Tasks;
import com.model.User.User;

public interface TasksService {
	public void addTasks(Tasks p);
	public void updateTasks(Tasks p);
	public List<Tasks> listTasks();
	public void removeTasks(int id);
}
