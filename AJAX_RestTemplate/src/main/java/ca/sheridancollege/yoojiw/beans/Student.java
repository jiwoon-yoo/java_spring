package ca.sheridancollege.yoojiw.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private int id; 
	
	private String firstName; 
	private String lastName; 
	private int age; 
	
	
}
