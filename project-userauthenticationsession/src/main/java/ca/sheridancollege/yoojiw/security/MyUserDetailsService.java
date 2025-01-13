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
import ca.sheridancollege.yoojiw.repo.RoleRepo;
import ca.sheridancollege.yoojiw.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private RoleRepo rr; 
	
	@Autowired
	private UserRepo ur;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = ur.findUserByUsername(username).orElseThrow(() ->  new UsernameNotFoundException("user not found") ); 
		
		List<String> roles =  rr.findRoleNameByUserId(user.getId()); 
		
		List<GrantedAuthority> grantList = new ArrayList<>(); 
		
		for(String  i : roles) {
			
			grantList.add(new SimpleGrantedAuthority(i)); 
		}
		
		return org.springframework.security.core.userdetails.User.builder()
						.username(user.getUsername())
						.password(user.getPassword())
						.authorities(grantList)
						.build(); 
		
		
	}

}
