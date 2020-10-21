package edu.curso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoController {
	
	@GetMapping("/cidades/{estado}")
	@ResponseBody
	public String[] getCidades(
			@PathVariable("estado") String estado) { 
		List<String> cidades = new ArrayList<>();
		if ("São Paulo".equals(estado)) { 
			cidades = Arrays.asList("Piracicaba", "São Paulo", "Taboão da Serra");
		} else if ("Rio de Janeiro".equals(estado)) { 
			cidades = Arrays.asList("Paraty", "Rio de Janeiro", "Angra dos Reis");
		} else if ("Minas Gerais".equals(estado)) {
			cidades = Arrays.asList("Belo Horizonte", "Uberaba", "Uberlândia");
		} else { 
			cidades = Arrays.asList("Outra");
		}
		return cidades.toArray(new String[] {});
	}

}
