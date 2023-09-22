package ca.sheridancollege.yoojiw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.yoojiw.database.DatabaseAccess;

@Controller
public class MainController {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/viewStudents")
	public String viewStudents(Model model) {
		
		
		model.addAttribute("allStudents", da.getAllStudents()); 
		
		
		return "viewStudents";
	}
	
	
}
