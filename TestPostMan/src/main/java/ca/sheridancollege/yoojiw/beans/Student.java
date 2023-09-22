package ca.sheridancollege.yoojiw.beans;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Student {

	private int id; 
	private String name; 
	private int age; 
	private boolean attended; 

	
	
}

