package ca.sheridancollege.yoojiw.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ca.sheridancollege.yoojiw.entity.Role;
import ca.sheridancollege.yoojiw.entity.User;
import ca.sheridancollege.yoojiw.entity.UserRole;
import ca.sheridancollege.yoojiw.repository.RoleRepo;
import ca.sheridancollege.yoojiw.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserSer {

	@Autowired
	private UserRepo ur; 
	
	@Autowired
	private RoleRepo rr; 
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	
	
	
	
	@Transactional
	public User registerUser(String username, String password) {
		

        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        User inputUser = ur.save(user);

        Role role = rr.findByName("ROLE_USER").orElseThrow(() -> new EntityNotFoundException());
        
        
        // user_role 저장
        int rowsAffected = ur.saveUserRole(inputUser.getId(), role.getId());

        System.out.println("Rows affected in user_role: " + rowsAffected);

        return  inputUser;  		
	}
	
	
	public boolean checkUserExist(String username) {
		
		return ur.findByUsername(username).isPresent();
	}
	

}
