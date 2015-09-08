package control;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.model.Category.Category;
import com.model.Data.Data;
import com.model.File.File;
import com.model.Note.Note;
import com.model.Tasks.Tasks;
import com.model.User.User;
import com.service.Category.CategoryService;
import com.service.DataService.DataService;
import com.service.FileService.FileService;
import com.service.Note.NoteService;
import com.service.UserService.UserService;

@Controller
public class NoteController {
	private NoteService 	noteService;
	private UserService 	userService;
	private DataService 	dataService;
	private FileService 	fileService;
	private CategoryService categoryService;

	
	public CategoryService getCategoryService() {
		return categoryService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public FileService getFileService() {
		return fileService;
	}

	@Autowired(required=true)
	@Qualifier(value="fileService")
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public UserService getUserService() {
		return userService;
	}
	
	public DataService getDataService() {
		return dataService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="dataService")
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
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
		
		model.addAttribute("category", new Category());
		model.addAttribute("listCategory", this.categoryService.listCategory());
		
		//
		File iFile = new File();
		Data iData = new Data();
		User iUser = new User();
		Note iNote = new Note();
		Category iCategory = new Category();
		
		model.addAttribute("addFile", iFile);
		model.addAttribute("addData", iData);
		model.addAttribute("addUser", iUser);
		model.addAttribute("addNote", iNote);
		model.addAttribute("addCategory", iCategory);
		
		return "newnote";
	}
	
	@RequestMapping(value="/newnote", method= RequestMethod.POST)
	private String saveNote(@Valid Note note, BindingResult result, @RequestParam MultipartFile[] fileUpload)
	{
		byte[] bytes = null;
		List<File> files = new ArrayList<File>();
		Data data = new Data();
		File file = new File();
		
		if(fileUpload[0].getSize()!=0)
		{
			for(MultipartFile mfile : fileUpload)
			{
				try 
				{
					
					file.setData(data);
					file.setFileName(mfile.getOriginalFilename());
					file.setFileSize(mfile.getSize());
					bytes = mfile.getBytes();
					data.setData(bytes);
				} 
				catch (IOException e) 
				{
				}
				files.add(file);
			}
			note.setFile(files);
		}
		
		Timestamp tstamp = new Timestamp(new Date().getTime()); 
		note.setDate(tstamp.toString());
		this.noteService.addNote(note);
		
		return "redirect:/note";
	}

}
