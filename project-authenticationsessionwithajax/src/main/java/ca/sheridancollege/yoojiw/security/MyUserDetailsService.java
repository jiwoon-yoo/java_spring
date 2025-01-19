package ca.sheridancollege.yoojiw.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancollege.yoojiw.entity.User;
import ca.sheridancollege.yoojiw.entity.UserRole;
import ca.sheridancollege.yoojiw.repository.RoleRepo;
import ca.sheridancollege.yoojiw.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private RoleRepo rr; 
	
	@Autowired
	private UserRepo ur; 
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		User user = ur.findByUsername(username).orElseThrow(() -> new RuntimeException("no user exits"));
		
		List<String> roleNames =  rr.findRoleNameByUserId(user.getId()); 
		
		if(roleNames == null) {
			throw new RuntimeException(); 
		}
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		
		for(String i : roleNames) {
			
			grantList.add(new SimpleGrantedAuthority(i)); 
		}
		
		
		
		
		return org.springframework.security.core.userdetails.User.builder()
					.username(user.getUsername())
					.password(user.getPassword())
					.authorities(grantList)
					.build(); 
	}

}
