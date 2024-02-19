package ca.sheridancollege.yoojiw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.PutExchange;

import ca.sheridancollege.yoojiw.benas.Student;
import ca.sheridancollege.yoojiw.database.DatabaseAccess;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private DatabaseAccess da;
	
	
	
	//get 
	@GetMapping(value = "/{id}")
	public Student getStudentById(@PathVariable  int id) {
		
		return da.getStudentById(id); 
	}
	
	//get
	@GetMapping()
	public List<Student> getAllStudents() {
		
		return da.getAllStudent(); 
	}
	
	
	//post
	@PostMapping()
	public int addStudent(@RequestBody Student student ) {
		
		int insertedStudentId = da.addStudent(student);
		
		return insertedStudentId; 
	}
	
	@PostMapping("/students")
	public int addStudents(@RequestBody List<Student> students) {
		
		int numOfInsertedStudents = da.addStudents(students); 
		
		return numOfInsertedStudents;
	}
	
	//put
	@PutMapping(value = "/{id}")
	public void updateStudent(@PathVariable int id,  @RequestBody Student student) {
		
		da.updateStudent(id, student); 
	}
	
	//delete 
	@DeleteMapping(value = "/{id}")
	public void deleteStudent(@PathVariable int id) {
		
		da.deleteStudent(id); 
	}
	
}
