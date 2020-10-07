package edu.curso;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class HelloService {
		
	List<String> emails = new ArrayList<>();
	
	public void adicionarEmail(String email) { 
		emails.add(email);
		System.out.printf("Possuem %d emails na lista%n", emails.size());
	}

}
