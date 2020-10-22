package edu.curso;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContatoController {
	
	@Autowired
	private List<Contato> lista;
	
	@Bean
	@ApplicationScope
	public List<Contato> listaContatos() { 
		return new ArrayList<>();
	}

	@GetMapping("/contato")
	public ModelAndView getContato() {
		ModelAndView mv = new ModelAndView("contato");
		
		Contato c = new Contato();

		mv.addObject("LISTA_CONTATO", lista);
		mv.addObject("CONTATO_ATUAL", c);
		
		return mv;
	}
	
	
	@PostMapping("/contato")
	public ModelAndView postContato(
			@ModelAttribute("CONTATO_ATUAL") Contato c,
			@RequestParam("cmd") String cmd) {
		ModelAndView mv = new ModelAndView("contato");
		mv.addObject("LISTA_CONTATO", lista);
		if ("adicionar".equals(cmd)) { 
			lista.add(c);
			System.out.printf("Contato adicionado, agora "
				+ "há %d contatos na lista%n", lista.size());
			mv.addObject("CONTATO_ATUAL", new Contato());			
		} else if ("pesquisar".equals(cmd)) { 
			List<Contato> listaTemporaria = new ArrayList<>();
			for (Contato contato : lista) { 
				if (contato.getNome().contains(c.getNome())) { 
					listaTemporaria.add(contato);
				}
			}
			mv.addObject("LISTA_CONTATO", listaTemporaria);
			mv.addObject("CONTATO_ATUAL", c);
		}		
		return mv;
	}
}
