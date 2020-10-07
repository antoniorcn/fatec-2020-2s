package edu.curso;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TesteSpring {
	public static void main(String[] args) {
		System.out.println("Programa Java Básico com Spring");
		ApplicationContext app = 
				new AnnotationConfigApplicationContext(HelloConfig.class);
		Hello h = app.getBean("hello", Hello.class);
		h.helloWorld();
		System.out.println("HashCode Instancia 1: " + h.toString());
		
		Hello h2 = app.getBean("hello", Hello.class);
		
		System.out.println("HashCode Instancia 2: " + h2.toString());
	}
}
