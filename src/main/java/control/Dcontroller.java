package control;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.GroupsService;
import com.service.TasksService;
import com.service.UserService;
import com.model.Groups;
import com.model.Tasks;
import com.model.User;

@Controller
public class Dcontroller {
	private UserService 	userService;
	private GroupsService 	groupsService;
	private TasksService 	tasksService;
	
	public UserService getUserService() {
		return userService;
	}
	
	public GroupsService getGroupsService() {
		return groupsService;
	}

	
	public TasksService getTasksService() {
		return tasksService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="tasksService")
	public void setTasksService(TasksService tasksService) {
		this.tasksService = tasksService;
	}

	@Autowired(required=true)
	@Qualifier(value="groupsService")
	public void setGroupsService(GroupsService groupsService) {
		this.groupsService = groupsService;
	}

	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService _userService) {
		this.userService = _userService;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUser(Model _model)
	{
		_model.addAttribute("user", new User());
		_model.addAttribute("listUser", this.userService.listUser());
		return "user";
		
	}
	
	@RequestMapping(value = "/groups", method = RequestMethod.GET)
	public String listGroups(Model _model)
	{
		_model.addAttribute("groups", new Groups());
		_model.addAttribute("listGroups", this.groupsService.listGroup());
		return "groups";
	}
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public String listTasks(Model _model)
	{
		_model.addAttribute("tasks", new Tasks());
		_model.addAttribute("listTasks", this.tasksService.listTasks());
		_model.addAttribute("userInTaskList", this.tasksService.listUserInTask(2));
		return "tasks";
	}
	
	@RequestMapping(value = "/groups/{id}", method = RequestMethod.GET)
	public String listUserInGroup (@PathVariable int id, Model _model)
	{
		_model.addAttribute("user", new User());
		_model.addAttribute("listUserById", this.groupsService.listUserInGroup(id));
		return "useringroup";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String addUser(Model _model)
	{
		User newuser = new User();
		_model.addAttribute("adduser",newuser);
		_model.addAttribute("edit",false);
		return "adduser";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String saveUser(@Valid User adduser, BindingResult result, Model _model)
	{
		if (result.hasErrors()) {
            return "adduser";
        }
		
		this.userService.addUser(adduser);
		_model.addAttribute("message", "User added: " + adduser.toString());
		return "redirect:/users";
	}
	
	@RequestMapping(value = "/delete/{userid}", method = RequestMethod.GET)	
	private String deletUser(@PathVariable String userid)
	{
		this.userService.removeUser(userid);
		return "redirect:/users";
	}	
}
