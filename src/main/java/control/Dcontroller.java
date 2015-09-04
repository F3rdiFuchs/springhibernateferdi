package control;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.CarService.CompanyCarService;
import com.service.Category.CategoryService;
import com.service.GroupService.GroupsService;
import com.service.GuarantorService.GuarantorService;
import com.service.MessageService.MessageService;
import com.service.Note.NoteService;
import com.service.TasksService.TasksService;
import com.service.UserService.UserService;
import com.model.CompanyCar.CompanyCar;
import com.model.Groups.Groups;
import com.model.Tasks.Tasks;
import com.model.User.User;
import com.model.Message.*;
import com.model.Note.Note;

@Controller
public class Dcontroller {
	private UserService 		userService;
	private GroupsService 		groupsService;
	private TasksService 		tasksService;
	private CompanyCarService 	companyCarService;
	private GuarantorService 	guarantorService;
	private MessageService 		messageService;
	private NoteService 		noteservice;
	private CategoryService		categoryService;
	
	
	
	public CategoryService getCategoryService() {
		return categoryService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public NoteService getNoteservice() {
		return noteservice;
	}
	
	@Autowired(required=true)
	@Qualifier(value="noteService")
	public void setNoteservice(NoteService noteservice) {
		this.noteservice = noteservice;
	}

	public MessageService getMessageService() {
		return messageService;
	}
	
	
	@Autowired(required=true)
	@Qualifier(value="messageService")
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public GuarantorService getGuarantorService() {
		return guarantorService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="guarantorService")
	public void setGuarantorService(GuarantorService guarantorService) {
		this.guarantorService = guarantorService;
	}

	public CompanyCarService getCompanyCarService() {
		return companyCarService;
	}

	@Autowired(required=true)
	@Qualifier(value="companyCarService")
	public void setCompanyCarService(CompanyCarService companyCarService) {
		this.companyCarService = companyCarService;
	}

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
	public void setUserService(UserService userService) {
		this.userService = userService;
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
	
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)	
	private String deletUser(@PathVariable Integer userId)
	{
		this.userService.removeUser(userId);
		return "redirect:/users";
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
	
	@RequestMapping(value = "/cars", method = RequestMethod.GET)	
	private String listCars(Model _model)
	{
		_model.addAttribute("companyCar", new CompanyCar());
		_model.addAttribute("listCompanyCar", this.companyCarService.listCompanyCar());
		return "cars";
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)	
	private String listMessages(Model _model)
	{
		_model.addAttribute("message", new Message());
		_model.addAttribute("listMessage", this.messageService.listMessages());
		return "message";
	}
	
	@RequestMapping(value = "/note", method = RequestMethod.GET)	
	private String listNotes(Model _model)
	{
		_model.addAttribute("note", new Note());
		_model.addAttribute("listNote", this.noteservice.listNotes());
		return "note";
	}
	
	
	
}
