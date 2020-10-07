package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/Teste")
	public String h1() { 
		System.out.println("Teste executado");
		return "index";
	}

}
