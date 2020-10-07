package edu.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {
	
	@Bean
	public Hello hello() { 
		return new Hello();
	}

}
