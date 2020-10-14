package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContatoController {
	@GetMapping("/contatos")
	public ModelAndView contatos() {
		Contato contato = new Contato();
		contato.setNome("Antonio Rodrigues");
		contato.setEmail("antoniorcn@hotmail.com");
		contato.setTelefone("(11) 11111-2222");
		ModelAndView mv = new ModelAndView("contato");
		mv.addObject("CONTATO_ATUAL", contato);
		return mv;
	}
	
	@PostMapping("/contato/adicionar")
	public ModelAndView contatoAdicionar(
			@ModelAttribute("CONTATO_ATUAL") Contato c) { 
		System.out.println("Nome: " + c.getNome());
		System.out.println("Email: " + c.getEmail());
		System.out.println("Telefone: " + c.getTelefone());
		ModelAndView mv = new ModelAndView("contato_adicionado");
		return mv;
	}
}
