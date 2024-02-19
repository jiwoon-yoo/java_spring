package ca.sheridancollege.yoojiw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ca.sheridancollege.yoojiw.database.DatabaseAccess;

@Service
public class RegisterService {

	@Autowired
	private DatabaseAccess da; 
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	
	public void registerUser(String username, String password, int roleId) {
		
		da.addUser(username, bCryptPasswordEncoder.encode(password)); 
		int userId = da.getUserIdByUsername(username); 
		da.addUser_role(userId, roleId); 
	}
}
