package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.User.User;
import com.service.UserService.UserService;

@Controller
public class LoginController {
	private UserService 		userService;

	public UserService getUserService() {
		return userService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("userName")String userName, @RequestParam("passWord")String passWord)
	{
		User tmp = new User();
		String message = "Wrong login data";
		if(this.userService.checkLogin(userName, passWord))
		{
			message = "" + userName;
		}
		return new ModelAndView("results","message",message);
		
	}
}
