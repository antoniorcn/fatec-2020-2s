package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	public void persistir(Contato c) { 
		contatoRepository.save(c);
	}
	
	public Iterable<Contato> consultaTodos() { 
		return contatoRepository.findAll();
	}
	
	public Iterable<Contato> consultarPorNome(String nome) { 
		return contatoRepository.searchLikeByNome(nome);
	}
	
	public void remover(Long id) { 
		contatoRepository.deleteById(id);
	}

}
