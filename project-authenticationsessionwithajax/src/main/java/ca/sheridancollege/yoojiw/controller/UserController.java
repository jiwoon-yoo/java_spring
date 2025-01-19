package ca.sheridancollege.yoojiw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.yoojiw.entity.User;
import ca.sheridancollege.yoojiw.service.RoleSer;
import ca.sheridancollege.yoojiw.service.UserSer;

@Controller
@RequestMapping("/user")
public class UserController {

	
	
	@GetMapping("/userIndex")
	public String userIndex() {
		
		return "user/userIndex"; 
	}
	
	@GetMapping("/myaccount")
	public String myaccount() {
		
		return "user/myaccount"; 
	}
	
	
	
}
