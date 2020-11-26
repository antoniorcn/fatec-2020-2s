package edu.curso;

import java.util.List;

public interface ContatoDAO {
	
	void adicionar(Contato c) throws DAOException;
	List<Contato> pesquisarPorNome(String nome) throws DAOException;

}
