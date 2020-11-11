package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImpl userDetailService;
	
	@Bean
	public PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public UserDetailsService userDetailService() { 
//		return new UserDetailServiceImpl();
//	}
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) {
//		try {
// 			auth.inMemoryAuthentication()
//			.withUser("user")
//			.password(passwordEncoder().encode("user"))
//			.roles("USER")
//			.and()
//			.withUser("manager")
//			.password(passwordEncoder().encode("manager"))
//			.roles("MANAGER", "USER");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) { 
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/livro").hasRole("USER")
		.antMatchers("/admin").hasRole("MANAGER")
		.antMatchers("/*").authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/loginController")
		.defaultSuccessUrl("/livro")
		.usernameParameter("username")
		.passwordParameter("password")
		.failureUrl("/loginFail")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login")
		.and().csrf().disable();
	}


}
