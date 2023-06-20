package ca.sheridancollege.yoojiw.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import ca.sheridancollege.yoojiw.beans.PlugInEV;
import ca.sheridancollege.yoojiw.database.DatabaseAccess;

@Controller
public class HomeController {

	@Autowired
	public DatabaseAccess da; 

	
	
	
	
	
	
//	@GetMapping("/")
//	public String index() {
//	    return "index";
//	}
	

	@GetMapping("/login")
	public String login() {
	    return "login";
	}

	@GetMapping("/permission-denied")
	public String permissionDenied() {
	    return "/error/permission-denied";
	}
	
	
	

	
	
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("pluginev", new PlugInEV()); 
		
		return "index.html"; 
	}
	
	
	@GetMapping("/secure")
	public String insertOnePlugInEV(@ModelAttribute PlugInEV pluginev, Model model) {
		
		da.insertOnePlugInEV(pluginev); 
		model.addAttribute("pluginev", new PlugInEV());		/////
		model.addAttribute("allPlugInEV", da.readAllPlugInEV()); 
		
		
		return "/secure/index.html"; 
	}

	
	@GetMapping("/delete/{id}")
	public String deletePlugInEV(@PathVariable int id, Model model) {
		
		da.deleteOnePlugInEV(id); 
		
		model.addAttribute("pluginev", new PlugInEV()); 		////////// 
		model.addAttribute("allPlugInEV", da.readAllPlugInEV());	
		
		return "/secure/index.html"; 
	}
	
	
	@GetMapping("/edit/{id}")
	public String editPlugInEV(@PathVariable int id, Model model) {
		
		model.addAttribute("pluginev", da.readOnePlugInEV(id)); 		////
		
		da.deleteOnePlugInEV(id); 
		
		model.addAttribute("allPlugInEV", da.readAllPlugInEV());	
		
		return "/secure/index.html";  
	}
	
	
	
	
	
}
