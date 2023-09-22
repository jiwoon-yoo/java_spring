package ca.sheridancollege.yoojiw.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.yoojiw.beans.Student;
import ca.sheridancollege.yoojiw.database.DatabaseAccess;
import lombok.AllArgsConstructor;

@Controller		////
public class HomeController {		//둘 controller 모두 요청, 응답  	//homecontroller은 응답을 주는데 초점 

	@GetMapping("/viewStudents")
	public String viewStudents(Model model, RestTemplate restTemplate) {		
		ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity  ("http://localhost:8080/students", Student[].class);		//URI resourcese	
	
		model.addAttribute("studentList", responseEntity.getBody());  	

		return "viewStudents.html";
	}

	
//	@GetMapping(value="/getStudent/{id}", produces="application/json")  	
//	@ResponseBody							//@ResponseBody는 server인 나의 응답
//	public Map<String, Object> getStudent(@PathVariable int id, RestTemplate restTemplate) {  		//restTemplate : server -> api 로 요청을 보낼떄 사용
//		
//		Map<String, Object> data = new HashMap<String, Object>();		
//		ResponseEntity<Student> responseEntity = restTemplate.getForEntity  ("http://localhost:8080/students/" + id, Student.class);		
//		data.put("student", responseEntity.getBody());		//
//	
//		return data;
//	}

}