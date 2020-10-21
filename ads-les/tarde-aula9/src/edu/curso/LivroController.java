package edu.curso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LivroController {
	
	@Autowired
	private List<Livro> lista;
	
	@Bean
	@ApplicationScope
	public List<Livro> gerarListaLivro() { 
		return new ArrayList<>();
	}
	
	@GetMapping("/livro/remover/{id}")
	public ModelAndView removeLivro(@PathVariable("id") Long id) { 
		Livro l = new Livro();
		System.out.println("Remover livro " + id);
		for (Livro livro : lista) { 
			if (livro.getId() == id) { 
				lista.remove(livro);
				break;
			}
		}
		ModelAndView mv = new ModelAndView("livro", "LIVRO_ATUAL", l);
		mv.addObject("LISTA", lista);
		return mv;
	}
	
	@GetMapping("/livro")
	public ModelAndView getLivro() { 
		Livro l = new Livro();
		l.setTitulo("");
		l.setAno(2020);
		l.setAutor("");
		l.setEditora("");
		ModelAndView mv = new ModelAndView("livro", "LIVRO_ATUAL", l);
		mv.addObject("LISTA", lista);
		return mv;
	}
	
	@RequestMapping(value="/livro", method=RequestMethod.POST)
	public ModelAndView postLivro(
			@Valid @ModelAttribute("LIVRO_ATUAL") Livro livro, 
			BindingResult result,
			@RequestParam("cmd") String cmd) {	
		ModelAndView mv = new ModelAndView("livro", "LIVRO_ATUAL", livro);
		mv.addObject("LISTA", lista);
		if ("adicionar".equals(cmd)) { 
			if (! result.hasErrors()) { 
				lista.add(livro);
				System.out.printf("Livro adicionado com sucesso,"
						+ " lista possui %d livros%n", lista.size());
			}
		} else if ("pesquisar".equals(cmd)){
			List<Livro> listaPesquisa = new ArrayList<>();
			for (Livro l : lista) { 
				if (l.getTitulo().contains(livro.getTitulo())) { 
					listaPesquisa.add(l);
				}
			}
			mv.addObject("LISTA", listaPesquisa);
		}
		
		return mv;
	}
	
	@ModelAttribute("ESTADOS")
	public List<String> getEstados() { 
		List<String> estados = Arrays. asList(
				"MG", 
				"RJ", 
				"SP");
		return estados;
	}

}
