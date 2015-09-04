package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Tasks.Tasks;
import com.model.User.User;
import com.service.TasksService.TasksService;
import com.service.UserService.UserService;

@Controller
public class TaskController {
	private TasksService 	tasksService;
	private UserService 	userService;
	
	public TasksService getTasksService() {
		return tasksService;
	}

	@Autowired(required=true)
	@Qualifier(value="tasksService")
	public void setTasksService(TasksService tasksService) {
		this.tasksService = tasksService;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)	
	private String listTasks(Model _model)
	{
		_model.addAttribute("tasks", new Tasks());
		_model.addAttribute("tasksList", this.tasksService.listTasks());
		return "tasks";
	}
	
	@RequestMapping(value = "/tasks/add", method = RequestMethod.GET)	
	private String addTasks(Model model)
	{
		model.addAttribute("user", new User());
		model.addAttribute("listUser", this.userService.listUser());
		
		Tasks newtasks = new Tasks();
		model.addAttribute("newtasks",newtasks);
		model.addAttribute("edit",false);
		
		newtasks.setStatus(false);
		newtasks.setUser(this.userService.listUser());
		
		return "addtask";
	}
	
	@RequestMapping(value = "/tasks/add", method = RequestMethod.POST)
	private String saveTasks(@ModelAttribute("userForm") Tasks tasks, BindingResult result, Model model)
	{	
		if (result.hasErrors()) {
            return "redirect:add";
		}
		this.tasksService.addTasks(tasks);
		
		return "redirect:/tasks";
	}
}

