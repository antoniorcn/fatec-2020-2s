package edu.curso;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContatoController {
	
//	@Autowired
//	private ContatoRepository contatoRepository;
	
	@Autowired
	private ContatoService contatoService;
	
	@GetMapping("/contato")
	public ModelAndView getContato() {
		ModelAndView mv = new ModelAndView("contato");
		
		Contato c = new Contato();
		Iterable<Contato> lista = contatoService.consultaTodos();

		mv.addObject("LISTA_CONTATO", lista);
		mv.addObject("CONTATO_ATUAL", c);
		
		return mv;
	}
	
	
	@PostMapping("/contato")
	public ModelAndView postContato(
			@ModelAttribute("CONTATO_ATUAL") @Valid Contato c,
			BindingResult result,
			@RequestParam("cmd") String cmd) {
		ModelAndView mv = new ModelAndView("contato");
		Iterable<Contato> lista = contatoService.consultaTodos();
		mv.addObject("LISTA_CONTATO", lista);
		Boolean mostraErros = false;
		if ("adicionar".equals(cmd)) { 
			if (!result.hasErrors()) {
				// contatoRepository.save(c);
				contatoService.persistir(c);
				mv.addObject("CONTATO_ATUAL", new Contato());
			} else { 
				mostraErros = true;
			}
		} else if ("pesquisar".equals(cmd)) { 
			Iterable<Contato> listaTemporaria = contatoService.consultarPorNome(c.getNome());
			mv.addObject("LISTA_CONTATO", listaTemporaria);
			mv.addObject("CONTATO_ATUAL", c);
		}
		mv.addObject("MOSTRAR_ERROS", mostraErros);
		return mv;
	}
	
	@PreAuthorize("hasAnyRole('MANAGER')")
	@GetMapping("/contato/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) { 
		
		contatoService.remover(id);
		
		ModelAndView mv = new ModelAndView("contato");
		Iterable<Contato> lista = contatoService.consultaTodos();
		mv.addObject("LISTA_CONTATO", lista);
		mv.addObject("CONTATO_ATUAL", new Contato());
		return mv;
	}
}
