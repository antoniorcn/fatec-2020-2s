package edu.curso;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer 
extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
//		System.out.println("Iniciando o WebInitializer");
//		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
//		String senhaCodificada = passEncoder.encode("123456");
//		System.out.println("Senha 123456 codificada: " + senhaCodificada);
		
		return new Class[] { SecurityConfig.class };
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { Config.class };
	}
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
