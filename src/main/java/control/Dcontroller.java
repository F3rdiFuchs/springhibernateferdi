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
	
	
	
	
	
	
}
