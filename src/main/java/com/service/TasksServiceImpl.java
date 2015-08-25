package com.service;

import java.util.List;

import com.model.Tasks;
import com.model.TasksDAO;
import com.model.User;

public class TasksServiceImpl implements TasksService{

	private TasksDAO tasksDAO;
	
	public void addTasks(Tasks p) {
		// TODO Auto-generated method stub
		
	}

	public TasksDAO getTasksDAO() {
		return tasksDAO;
	}

	public void setTasksDAO(TasksDAO tasksDAO) {
		this.tasksDAO = tasksDAO;
	}

	public void updateTasks(Tasks p) {
		// TODO Auto-generated method stub
		
	}

	public List<Tasks> listTasks() {
		return this.tasksDAO.listTasks();
	}

	public List<User> listUserInTask(int id) {
		return tasksDAO.listUserInTask(id);
	}

	public void removeTasks(int id) {
		// TODO Auto-generated method stub
		
	}

}
