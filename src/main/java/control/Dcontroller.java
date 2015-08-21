package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.UserDAOImpl;
import com.service.GroupsService;
import com.service.UserService;
import com.model.Groups;
import com.model.User;

@Controller
public class Dcontroller {
	private UserService 	userService;
	private GroupsService 	groupsService;
	
	public UserService getUserService() {
		return userService;
	}
	
	public GroupsService getGroupsService() {
		return groupsService;
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
		return "user";
		
	}
	
}
