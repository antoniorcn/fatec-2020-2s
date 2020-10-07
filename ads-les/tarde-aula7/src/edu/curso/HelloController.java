package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@Autowired
	HelloService svc;
	
	@GetMapping("/Simples")
	public String simples() { 
		System.out.println("Teste executado");
		return "index";
	}
	
	@GetMapping("/Hello/{nome}")
	public ModelAndView hello(@RequestParam("EMAIL") String email,
			@RequestParam("P2") String p2,
			@PathVariable("nome") String nomePessoa) { 
		ModelAndView mv = new ModelAndView("index");
		String msg = "Ola " + nomePessoa + " teste executado " + email + " - " + p2;
		mv.addObject("MENSAGEM", msg);
		svc.adicionarEmail(email);
		System.out.println(msg);
		return mv;
	}

}
