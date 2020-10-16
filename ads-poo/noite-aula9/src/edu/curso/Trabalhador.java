package edu.curso;

public class Trabalhador implements Assinante {
	private String nome;
	
	public Trabalhador(String nome) { 
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void receberNoticia(String noticia) {
		System.out.println("Trabalhador " + nome + " lendo " + noticia);
	}
}
