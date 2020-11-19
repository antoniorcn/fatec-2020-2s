package edu.curso;

public interface ContatoDAO {
	
	void adicionar(Contato c) throws DAOException;
	Contato pesquisarPorNome(String nome) throws DAOException;

}
