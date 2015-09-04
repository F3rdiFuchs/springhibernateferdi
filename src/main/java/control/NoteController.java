package control;


import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.model.File.File;
import com.model.Note.Note;
import com.model.Tasks.Tasks;
import com.model.User.User;
import com.service.Note.NoteService;
import com.service.UserService.UserService;

@Controller
public class NoteController {
	private NoteService 	noteService;
	private UserService 	userService;

	public UserService getUserService() {
		return userService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public NoteService getNoteService() {
		return noteService;
	}

	@Autowired(required=true)
	@Qualifier(value="noteService")
	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@RequestMapping(value = "/note", method = RequestMethod.GET)	
	private String listNotes(Model _model)
	{
		_model.addAttribute("note", new Note());
		_model.addAttribute("listNote", this.noteService.listNotes());
		return "note";
	}
	
	@RequestMapping(value = "/newnote", method = RequestMethod.GET)
	private String newNote(Model model)
	{
		model.addAttribute("user", new User());
		model.addAttribute("listUser", this.userService.listUser());
		
		Note newNote = new Note();
		
		model.addAttribute("newNote",newNote);
		model.addAttribute("edit",false);
		
		return "newnote";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/newnote", method= RequestMethod.POST)
	private @ResponseBody String saveNote(@ModelAttribute("notes") Note notes, Model model)
	{
		
		//this.noteService.addNote(note);
		return "redirect:/note";
	}

}
