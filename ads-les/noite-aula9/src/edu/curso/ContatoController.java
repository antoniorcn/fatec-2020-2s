package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContatoController {

	@GetMapping("/contato")
	public ModelAndView getContato() {
		ModelAndView mv = new ModelAndView("contato");
		
		Contato c = new Contato();
		c.setNome("Antonio");
		c.setTelefone("(11) XXXX-YYYY");
		
		mv.addObject("CONTATO_ATUAL", c);
		
		return mv;
	}
	
	
	@PostMapping("/contato")
	public ModelAndView postContato(
			@ModelAttribute("CONTATO_ATUAL") Contato c) {
		System.out.println(c.getNome());
		System.out.println(c.getTelefone());
		System.out.println(c.getEmail());
		return new ModelAndView("contato", "CONTATO_ATUAL", new Contato());
	}
}
