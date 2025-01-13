package ca.sheridancollege.yoojiw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicController {

	@GetMapping("/")
	public String index() {
		
		return "public/index"; 
	}
	
	
	@GetMapping("/permission-denied")
	public String permissionDenied() {
		
		return "public/permission-denied"; 
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "public/login";  
	}
	
	
}
