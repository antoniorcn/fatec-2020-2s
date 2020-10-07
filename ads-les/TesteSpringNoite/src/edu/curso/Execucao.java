package edu.curso;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Execucao {
	@Bean
	public Professor geraProfessor() { 
		return new Professor();
	}
	public static void main(String[] args) { 
		AnnotationConfigApplicationContext app =
				new AnnotationConfigApplicationContext(Execucao.class);

		Professor p1 = app.getBean(Professor.class);
		Professor p2 = app.getBean(Professor.class);
		
		System.out.println("Professor Gerado p1: " + p1.toString());
		System.out.println("Professor Gerado p2: " + p2.toString());
	}
}
