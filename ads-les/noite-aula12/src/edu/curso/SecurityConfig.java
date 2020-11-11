package edu.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
	extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) {
		try {
			auth.inMemoryAuthentication()
			.withUser("user")
			.password(passwordEncoder().encode("user"))
			.roles("USER")
			.and()
			.withUser("manager")
			.password(passwordEncoder().encode("manager"))
			.roles("USER", "MANAGER");
	   } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/contato").hasRole("USER")
		.antMatchers("/contato/remover/*").hasRole("MANAGER")
		.antMatchers("/admin").hasRole("MANAGER")
		.antMatchers("/*").authenticated().and()
		.formLogin()
		.usernameParameter("username")
		.passwordParameter("password")
		.loginProcessingUrl("/loginController")
		.loginPage("/login")
		.failureUrl("/loginFail").defaultSuccessUrl("/contato")
		.permitAll()
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
		.and().csrf().disable();
	}


}
