package ca.sheridancollege.yoojiw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.yoojiw.entity.User;
import ca.sheridancollege.yoojiw.service.RoleSer;
import ca.sheridancollege.yoojiw.service.UserSer;

@Controller
public class MainController {

	
	@Autowired
	private RoleSer rs; 
	
	@Autowired
	private UserSer us; 
	
	
	
	
	
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
	
	@GetMapping("/register")
	public String register() {
		
		return "public/register";
	}
	
	@PostMapping("/register")
	public String postMethodName(@RequestParam String username, @RequestParam String password) {
		
		
		User registeredUser = us.registerUser(username, password); 
		
		System.out.println("successfully registered : " + registeredUser.getUsername());
		
		
		return "redirect:/";
	}
	
	@ResponseBody
	@GetMapping("/check-user")
	public boolean checkUser(@RequestParam String username) {
		
		System.out.println(us.checkUserExist(username));
		
		return us.checkUserExist(username); 	
	}
	
	
	
}
