package com.service.TasksService;

import java.util.List;

import com.model.Tasks.Tasks;
import com.model.Tasks.TasksDAO;
import com.model.User.User;

public class TasksServiceImpl implements TasksService{

	private TasksDAO tasksDAO;
	
	public void addTasks(Tasks tasks) {
		this.tasksDAO.addTasks(tasks);
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

	public void removeTasks(int id) {
		// TODO Auto-generated method stub
	}

}
