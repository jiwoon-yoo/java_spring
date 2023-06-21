package ca.sheridancollege.yoojiw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ca.sheridancollege.yoojiw.database.DatabaseAccess;

@Service
public class UserService {

	
	private DatabaseAccess da; 
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
	public UserService(DatabaseAccess da, PasswordEncoder passwordEncoder) {
		this.da = da;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	public void register(String username, String password, int role_id) {
	    if (da.searchUserName(username)) {
	        System.out.println("Username is already taken");
	        return;
	    }

	    String encodedPassword = passwordEncoder.encode(password);
	    da.registerUser(username, encodedPassword);

	    int user_id = da.searchUserId(username, encodedPassword);
	    da.registerUserRole(user_id, role_id);
	}

	
}
