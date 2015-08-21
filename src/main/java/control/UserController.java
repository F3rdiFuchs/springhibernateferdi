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
import com.service.UserService;
import com.model.User;

@Controller
public class UserController {
	private UserService userService;
	
	
	public UserService getUserService() {
		return userService;
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
	
}
