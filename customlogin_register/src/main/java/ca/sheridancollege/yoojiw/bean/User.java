package ca.sheridancollege.yoojiw.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User {

	private int userId; 
	private String username; 
	private String password; 
	
	
	
}
