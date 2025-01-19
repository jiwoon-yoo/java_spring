package ca.sheridancollege.yoojiw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.yoojiw.repository.RoleRepo;
import ca.sheridancollege.yoojiw.repository.UserRepo;
import jakarta.transaction.Transactional;

@Service
public class RoleSer {

	@Autowired
	private UserRepo ur; 
	
	@Autowired
	private RoleRepo rr; 
	
	
	

	
	
}
