package ca.sheridancollege.yoojiw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping(produces="application/json")
	@ResponseBody
	public List<Student> getAllStudents() {
		
		return da.getAllStudents();
	}

	
	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseBody
	public Student getStudentById(@PathVariable int id) {
		
		return da.getOneStudentById(id);
	}
	
	@PostMapping(consumes = "application/json")
	public int postOneStudent(@RequestBody Student student) {
		
		return da.insertOneStudent(student); 
	}
	
	@PutMapping(consumes = "application/json")
	public String putAllStudent(@RequestBody List<Student> students) {
		
		da.deleteAllStudents(); 
		da.insertStudents(students);
		
		return "total students records : " + da.countAllStudents(); 
	}
	
	//외부 서버로 get request 보내기 (여기서는 편의상 local로 보냄)
	@GetMapping(value = "/getStudent/{id}", produces = "application/json")
	@ResponseBody		//주의. 반드시 써야함 
	public Student getStudentById(@PathVariable int id, RestTemplate restTemplate) {
		
		ResponseEntity<Student> responseEntity = restTemplate.getForEntity("http://localhost:8080/students/" + id, Student.class); 
	
		return responseEntity.getBody(); 
	}
}
