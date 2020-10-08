package edu.curso;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@GetMapping("/teste")
	public String teste() { 
		return "teste";
	}
	
	@GetMapping("/tabuada/{NUMERO}") 
	public ModelAndView tabuada(@PathVariable("NUMERO") int num, 
			@RequestParam("INICIO") Optional<Integer> inicio,
			@RequestParam("FIM") Optional<Integer> fim) { 
		ModelAndView mv = new ModelAndView("tabuada");
		
		StringBuffer sb = new StringBuffer();
		for (int i = inicio.orElse(1); i <= fim.orElse(10); i++) { 
			sb.append(String.format("<p>%d X %d = %d</p>%n", num, i, num * i));
		}
		mv.addObject("TABUADA", sb);
		
		return mv;
	}
}
