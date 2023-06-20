package ca.sheridancollege.yoojiw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ca.sheridancollege.yoojiw.services.UserDetailsServiceImpl;



@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {	//passwordEncoder()
		
		return new BCryptPasswordEncoder();
	}

	@Autowired
	UserDetailsServiceImpl userDetailsService;		/////

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();				
		http.headers().frameOptions().disable();
		http.authorizeRequests()
			.antMatchers("/secure/**").hasRole("USER")		//
			.antMatchers("/", "/js/**", "/css/**", "/images/**", "/**").permitAll()
			.antMatchers("/h2-console/**").permitAll()
			.anyRequest().authenticated()		//
			.and().formLogin()
			.loginPage("/login").permitAll()		//
			.and().logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login?logout").permitAll()
			// a tiny bit more to place here in a few slides
			.and().exceptionHandling()
			.accessDeniedHandler(accessDeniedHandler);		//

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {	//configure our global authentication 
		auth.userDetailsService(userDetailsService)		
			.passwordEncoder(passwordEncoder());
	}
	//from our custom login form and encode their password to "compare" against the encrypted database value!


}