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

import com.model.User.User;
import com.service.UserService.UserService;

@Controller
public class UserController {
	private UserService 		userService;

	public UserService getUserService() {
		return userService;
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
	
	
}
