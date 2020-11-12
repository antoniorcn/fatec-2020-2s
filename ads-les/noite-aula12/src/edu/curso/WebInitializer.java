package edu.curso;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer 
extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Iniciando o WebInitializer");
		PasswordEncoder passEncoder = new BCryptPasswordEncoder();
		String senhaUserCodificada = passEncoder.encode("user");
		String senhaManagerCodificada = passEncoder.encode("manager");
		System.out.println("Senha User codificada: " + senhaUserCodificada);
		System.out.println("Senha Manager codificada: " + senhaManagerCodificada);
		
		return new Class[] { Config.class, SecurityConfig.class };
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {  };
	}
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
