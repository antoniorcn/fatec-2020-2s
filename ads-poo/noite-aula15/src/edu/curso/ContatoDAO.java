package edu.curso;

import java.util.List;

public interface ContatoDAO {
	
	void adicionar(Contato c) throws ContatoException;
	List<Contato> pesquisarPorNome(String nome) throws ContatoException;

}
