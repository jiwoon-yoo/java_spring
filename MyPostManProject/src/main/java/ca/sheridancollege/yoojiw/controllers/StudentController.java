package ca.sheridancollege.yoojiw.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import lombok.AllArgsConstructor;

//RestController -  @RestController 어노테이션이 지정된 클래스의 메서드에서 자바 객체를 반환하면 기본적으로 해당 객체를 JSON 형식으로 변환하여 응답으로 반환
@RestController		@RequestMapping("/students")		
@AllArgsConstructor	
public class StudentController {		//둘 controller 모두 요청, 응답  	//StudentController는 요청을 받아 처리하는 데 초점 

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping(produces = "application/json")
	public List<Student> getStudentCollection() {
		
		return da.findAll();		
	} 
	
	@GetMapping(value = "/{id}")
	public Student getIndividualStudent(@PathVariable Long id) {
		
		return da.findById(id);
	}
	
	@PostMapping(consumes = "application/json")
	public Long postStudent(@RequestBody Student student) {		
		
		return da.save(student);		//save
	}
	
	@PutMapping(consumes="application/json")
	public String putStudentCollection(@RequestBody List<Student> studentList) {
		da.deleteAll();		//
		da.saveAll(studentList);		//saveAll
		
		return "Total Records: " + da.count();
	}
	
	
	
//	@GetMapping(value="/getStudent/{id}", produces="application/json")  	
//	@ResponseBody							//@RestController를 사용하면 메서드에 @ResponseBody 어노테이션을 추가하지 않아도
//	public Map<String, Object> getStudent(@PathVariable int id, RestTemplate restTemplate) {  		//RestTemplate : 현재 web server -> 다른 web server(or 현재 web server 내부)로 request를 보냄 		
//		Map<String, Object> data = new HashMap<String, Object>();		
//		ResponseEntity<Student> responseEntity = restTemplate.getForEntity  ("http://localhost:8080/students/" + id, Student.class);		//Student 객체 타입의 data 전송 
//		data.put("student", responseEntity.getBody());		
//	
//		return data;
//	}
	@GetMapping(value="/getStudent/{id}", produces="application/json")  	
	@ResponseBody
	public List<Student> getStudent(@PathVariable int id, RestTemplate restTemplate) {
	    ResponseEntity<Student> responseEntity = restTemplate.getForEntity("http://localhost:8080/students/" + id, Student.class);
	    List<Student> studentList = new ArrayList<>();
	    studentList.add(responseEntity.getBody());
	    return studentList;
	}


}