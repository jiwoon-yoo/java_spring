package ca.sheridancollege.yoojiw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.yoojiw.beans.Product;
import ca.sheridancollege.yoojiw.beans.Student;
import ca.sheridancollege.yoojiw.database.DatabaseAccess;

@Controller
public class MainController {

	@Autowired
	private DatabaseAccess da;
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Student> students = da.getAllStudents(); 
		
		model.addAttribute("students", students); 
		
		
		return "index"; 
	}

	
	//server - server 통신 
	@GetMapping("/next")
	public String next(RestTemplate restTemplate, Model model) {
		
		ResponseEntity<Student[]> responseEntity  =  restTemplate.getForEntity("http://localhost:8080/student", Student[].class);
		
		model.addAttribute("students", responseEntity.getBody()); 
		
		return "next"; 
	}
	
	
}
