package ca.sheridancollege.yoojiw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private AccessDeniedHandler accessDeniedHandler; 
	
	@Autowired
	private MyUserDetailsService detailsService; 
	
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception {
		
		http.csrf()
				.disable()
			.authorizeHttpRequests(request -> request
			        .requestMatchers("/admin/**").hasRole("ADMIN")
			        .requestMatchers("/user/**").hasRole("USER")
			        .requestMatchers("/public/**").permitAll()  // 수정
			        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll() // 수정
					.anyRequest().authenticated()  )
			.formLogin(form -> form
					.loginPage("/public/login")
					.defaultSuccessUrl("/public/")
					.permitAll()  )
			.logout(logout -> logout
					.logoutUrl("/public/logout")
					.logoutSuccessUrl("/public/login?logout")  
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					.permitAll() ) 
			.exceptionHandling(exception -> exception 
					.accessDeniedHandler(accessDeniedHandler)); 
			
				
		return http.build();		
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder(); 
	}
	
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(detailsService).passwordEncoder(bCryptPasswordEncoder()); 
	}
}
