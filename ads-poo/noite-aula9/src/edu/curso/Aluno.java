package edu.curso;

public class Aluno implements Assinante {
	private String nome;
	
	public Aluno(String nome) { 
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
		System.out.println("Aluno " + nome + " lendo " + noticia);
	}
}
