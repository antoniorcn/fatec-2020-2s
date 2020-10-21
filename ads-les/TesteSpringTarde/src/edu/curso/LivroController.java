package edu.curso;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LivroController {
	
	@GetMapping("/livro")
	public ModelAndView getLivro() { 
		Livro l = new Livro();
		l.setTitulo("Use a cabeça Java");
		l.setAno(2010);
		l.setAutor("Katty Sierra");
		l.setEditora("conallen");
		ModelAndView mv = new ModelAndView("livro", "LIVRO_ATUAL", l);
		return mv;
	}
	
	@ModelAttribute("ESTADOS")
	public List<String> getEstados() { 
		List<String> estados = Arrays. asList(
				"Minas Gerais", 
				"Rio de Janeiro", 
				"São Paulo");
		return estados;
	}

}
