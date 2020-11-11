package edu.curso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoController {
	
	@RequestMapping(value="/cidades/{estado}", 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String getCidades(
			@PathVariable("estado") String estado) { 
		List<String> cidades = new ArrayList<>();
		System.out.println("Estado: " + estado);
		if ("SP".equals(estado)) { 
			cidades = Arrays.asList("Piracicaba", "São Paulo", "Taboão da Serra");
		} else if ("RJ".equals(estado)) { 
			cidades = Arrays.asList("Paraty", "Rio de Janeiro", "Angra dos Reis");
		} else if ("MG".equals(estado)) {
			cidades = Arrays.asList("Belo Horizonte", "Uberaba", "Uberlândia");
		} else { 
			cidades = Arrays.asList("Outra");
		}
		StringBuffer sb = new StringBuffer();
		for (String cidade : cidades) { 
			sb.append(cidade + "\n");
		}
		return sb.toString();
	}


}
