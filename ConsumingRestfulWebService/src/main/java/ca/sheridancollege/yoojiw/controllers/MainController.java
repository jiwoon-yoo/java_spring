package ca.sheridancollege.yoojiw.controllers;

import java.util.ArrayList;

import javax.imageio.spi.RegisterableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.yoojiw.benas.Student;
import ca.sheridancollege.yoojiw.database.DatabaseAccess;
import ca.sheridancollege.yoojiw.service.RegisterService;

@Controller
public class MainController {

	@Autowired
	private DatabaseAccess da;
	
	@Autowired
	private RegisterService registerService; 
	
	
	
	@GetMapping("/")
	public String index() {
		
		return "index"; 
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login"; 
	}
	
	@GetMapping("/error/permission-denied")
	public String permissioneDenied() {
		
		return "error/permission-denied"; 
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "register"; 
	}
	
	
	@PostMapping("/register")
	public String registerPost(@RequestParam String username, @RequestParam String password, @RequestParam int roleId) {
		
		registerService.registerUser(username, password, roleId); 
		
		return "redirect:/"; 
	}
	
	
	
	
	
	
	//consuming restful web service code 
	@GetMapping("/next")
	public String next(RestTemplate restTemplate) {
		
		//getForObject
//		Student[] students = restTemplate.getForObject("http://localhost:8080/student", Student[].class); 
//		
//		for(Student i : students) {
//			
//			System.out.println(i.getName());
//		}
		
		//getForEntity 
//		ResponseEntity<Student[]> responseEntity =restTemplate.getForEntity("http://localhost:8080/student", Student[].class); 
		
//		for(Student i : responseEntity.getBody()) {
//			System.out.println(i.getName());
//		}
		
		
		//postForObject 
//		Student s1 = new Student("liz"); 
//		int insertedStudentid = restTemplate.postForObject("http://localhost:8080/student", s1, Integer.class); 
//		System.out.println(insertedStudentid);
		
		//postForEntity 
//		Student s2 = new Student("sfasd");
//		Student s3 = new Student("aaaaaa");
//		ArrayList<Student> students = new ArrayList<>(); 
//		students.add(s2);
//		students.add(s3); 
//		
//		ResponseEntity<Integer> responseEntity =  restTemplate.postForEntity("http://localhost:8080/student/students", students, Integer.class);
//		
//		System.out.println(responseEntity.getBody());
//		
		
		//put() 
//		Student s4 = new Student("KATE"); 
//		restTemplate.put("http://localhost:8080/student/{id}", s4, 1); 

		
		//delete()
		restTemplate.delete("http://localhost:8080/student/{id}", 1); 
		
		
		return "next"; 
	}
}
