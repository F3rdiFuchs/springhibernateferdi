package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Groups.Groups;
import com.service.GroupService.GroupsService;

@Controller
public class GroupController {
	private GroupsService 	groupsService;
	
	public GroupsService getGroupsService() {
		return groupsService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="groupsService")
	public void setGroupsService(GroupsService groupsService) {
		this.groupsService = groupsService;
	}
	
	@RequestMapping(value = "/groups", method = RequestMethod.GET)
	public String listGroups(Model _model)
	{
		_model.addAttribute("groups", new Groups());
		_model.addAttribute("listGroups", this.groupsService.listGroup());
		return "groups";
	}
}
