package ca.sheridancollege.yoojiw.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.yoojiw.beans.Manufacturer;
import ca.sheridancollege.yoojiw.database.DatabaseAccess;


@Controller
public class ManufacturerController {

	@Autowired
	public DatabaseAccess da; 
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("manufacturer", new Manufacturer()); 
		
		return "index.html"; 
	}
	
	
	@PostMapping("/result")
	public String insertOneManufacturer(@ModelAttribute Manufacturer manufacturer, Model model) {
		
		da.insertOneManufacturer(manufacturer); 
		model.addAttribute("manufacturer", new Manufacturer());		/////
		model.addAttribute("allManufacturer", da.readAllManufacturer()); 
		
		
		return "index.html"; 
	}

	
	@GetMapping("/delete/{id}")
	public String deleteManufacturer(@PathVariable int id, Model model) {
		
		da.deleteOneManufacturer(id); 
		
		model.addAttribute("manufacturer", new Manufacturer()); 		////////// 
		model.addAttribute("allManufacturer", da.readAllManufacturer());	
		
		return "index.html"; 
	}
	
	
	@GetMapping("/edit/{id}")
	public String editManufacturer(@PathVariable int id, Model model) {
		
		model.addAttribute("manufacturer", da.readOneManufacturer(id)); 		////
		
		da.deleteOneManufacturer(id); 
		
		model.addAttribute("allManufacturer", da.readAllManufacturer());	
		
		return "index.html";  
	}
	
	
}
