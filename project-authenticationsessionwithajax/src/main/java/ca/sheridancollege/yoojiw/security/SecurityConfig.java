package ca.sheridancollege.yoojiw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

	
	@Autowired
	private MyAccessDeniedHandler accessDeniedHandler;  
	
	@Autowired
	private MyUserDetailsService detailsService;
	
	
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception {
		
		http.csrf()
				.disable()
			.authorizeHttpRequests(request -> {
						 request.requestMatchers("/admin/**").hasRole("ADMIN")
							    .requestMatchers("/user/**").hasRole("USER")
							    .requestMatchers("/images/**", "/js/**", "/css/**").permitAll()
							    .requestMatchers("/**").permitAll()
							    .anyRequest().authenticated(); }   )
			.formLogin(form ->{ 
							form.loginPage("/login")
								.defaultSuccessUrl("/")
								.permitAll(); }    )  
			.logout(logout -> {
							logout.logoutUrl("/logout")
								  .logoutSuccessUrl("/login?logout")
								  .invalidateHttpSession(true)
								  .deleteCookies("JSESSIONID")
								  .permitAll();  })
			.exceptionHandling(except -> {
							except.accessDeniedHandler(accessDeniedHandler);}   )
        .headers(headers -> headers.frameOptions().disable()); // Frame 옵션 비활성화

		
		return http.build(); 
	}
	
	
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(detailsService).passwordEncoder(bCryptPasswordEncoder()); 
		
	}
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder(); 
	}
}
