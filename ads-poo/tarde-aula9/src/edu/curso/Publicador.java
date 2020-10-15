package edu.curso;

public interface Publicador {
	
	void adicionarAssinante(Assinante a);
	void removerAssinante(Assinante a);
	void notificar(String msg);

}
