package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContatoController {

	@GetMapping("/contato")
	public String getContatos() { 
		return "contato";
	}
}
