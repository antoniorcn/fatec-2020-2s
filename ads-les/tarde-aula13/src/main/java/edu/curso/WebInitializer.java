package edu.curso;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends 
	AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{
			Config.class, SecurityConfig.class
			};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// return new Class[] { Config.class };
		return null;
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
