package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class Jornal implements Publicador{
	private String nome;
	private List<Assinante> assinantes = new ArrayList<>();

	public Jornal(String nome) { 
		this.setNome(nome);
	}
	
	@Override
	public void adicionar(Assinante a) {
		assinantes.add(a);
	}

	@Override
	public void remover(Assinante a) {
		assinantes.remove(a);
	}

	@Override
	public void distribuirNoticia(String noticia) {
		for(Assinante a : assinantes) { 
			a.receberNoticia("Jornal " + nome + " informa: " + noticia);
		}
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
