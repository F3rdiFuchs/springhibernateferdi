package com.service;

import java.util.List;

import com.model.Tasks;
import com.model.User;

public interface TasksService {
	
		public void addTasks(Tasks p);
	    public void updateTasks(Tasks p);
	    public List<Tasks> listTasks();
	    public List<User> listUserInTask(int id);
	    public void removeTasks(int id);
	
}
