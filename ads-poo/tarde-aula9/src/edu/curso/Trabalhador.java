package edu.curso;

public class Trabalhador implements Assinante {

	private String nome;
	
	public Trabalhador(String nome) { 
		this.nome = nome;
	}

	@Override
	public void receberInformacao(String msg) {
		String texto = String.format("Trabalhador %s esta lendo %s", nome, msg);
		System.out.println(texto);
	}
}
