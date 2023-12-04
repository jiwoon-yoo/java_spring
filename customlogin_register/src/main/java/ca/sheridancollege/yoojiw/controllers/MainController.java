package ca.sheridancollege.yoojiw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.yoojiw.database.DatabaseAccess;

@Controller
public class MainController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	@Autowired
	private DatabaseAccess da;
	
	
	@GetMapping("/")
	public String index() {
		
		return "index"; 
	}
	
	@GetMapping("/secure/admin/productManage")
	public String productManage() {
		
		return "secure/admin/productManage"; 
	}

	@GetMapping("/secure/mypage")
	public String mypage() {		//for USER account 
		
		return "secure/mypage"; 
	}
	
	
	@GetMapping("/login")
	public String login() {
		
		return "login"; 
	}

	@GetMapping("/permission-denied")
	public String permissionDenied() {
		
		return "permission-denied"; 
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "register"; 
	}
	
	@PostMapping("/register")
	public String postRegister(@RequestParam String username, @RequestParam String password) {
		
		//store in db 
		da.insertOneUser(username, bCryptPasswordEncoder.encode(password)); 
		
		int userId = da.getUserIdByUsername(username); 
		da.insertUserRole(userId); 
		
		return "redirect:/";
	}
	
}
