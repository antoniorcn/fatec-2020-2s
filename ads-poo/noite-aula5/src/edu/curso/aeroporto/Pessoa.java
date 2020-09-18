package edu.curso.aeroporto;

public class Pessoa {
	String nome;
	String cpf;
	double altura;
	
	public Pessoa(String nome) {
		this.nome = nome;
		System.out.println("Instanciando Pessoa");
	}
	
	public void andar() { 
		System.out.println("Andando...");
	}

}
