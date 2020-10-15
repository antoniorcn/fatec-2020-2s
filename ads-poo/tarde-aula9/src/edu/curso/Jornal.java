package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class Jornal implements Publicador {
	List<Assinante> assinantes = new ArrayList<>();
	private String nome;
	
	public Jornal(String nome) { 
		this.nome = nome;
	}
	
	@Override
	public void adicionarAssinante(Assinante a) {
		assinantes.add(a);
	}

	@Override
	public void removerAssinante(Assinante a) {
		assinantes.remove(a);
	}

	@Override
	public void notificar(String msg) {
		for (Assinante a : assinantes) {
			String texto = String.format("Jornal %s informa %s", nome, msg);
			a.receberInformacao(texto);
		}
	}

}
