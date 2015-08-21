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
import com.model.User;

@Controller
public class UserController {
	private UserDAOImpl user;

	public UserDAOImpl getUser() {
		return user;
	}

	public void setUser(UserDAOImpl user) {
		this.user = user;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String listUser(Model model)
	{
		model.addAttribute("user", new User());
		model.addAttribute("listUser", this.user.list());
		return null;
		
	}
	
}
