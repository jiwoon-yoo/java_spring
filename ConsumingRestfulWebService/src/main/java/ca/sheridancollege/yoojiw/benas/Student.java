package ca.sheridancollege.yoojiw.benas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

	private int studentId; 
	private String name;
	
	
	
	
	
	public Student(String name) {
		this.name = name;
	}  
	
	
	
}
