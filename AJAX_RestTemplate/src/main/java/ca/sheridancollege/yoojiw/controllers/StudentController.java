package ca.sheridancollege.yoojiw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.yoojiw.beans.Student;
import ca.sheridancollege.yoojiw.database.DatabaseAccess;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private DatabaseAccess da; 
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Student getStudent(@PathVariable int id) {
		
		Student student = da.getOneStudentById(id);
		
		return student; 
	}
	
	@GetMapping(produces = "application/json")
	public List<Student> getAllStudent(){
		
		List<Student> students = da.getAllStudents(); 
		
		return students; 
	}

}
