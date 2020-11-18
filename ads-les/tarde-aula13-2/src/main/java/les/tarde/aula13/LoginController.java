package les.tarde.aula13;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String login() { 
		return "login";
	}
	@GetMapping("/loginFail")
	public ModelAndView loginFail() { 
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("ERRO", "Usuario ou senha inválidos");
		return mv;
	}
	@PostMapping("/loginController")
	public String loginController() { 
		return "livro";
	}
	@GetMapping("/logout")
	public String logout() { 
		return "login";
	}
}
