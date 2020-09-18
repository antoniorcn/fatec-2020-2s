package edu.curso.construtores;

public class Pessoa extends Animal {
	String nome;
	
	public Pessoa() { 
		this("João Silva");
	}
	
	public Pessoa(String nome) {
		super();
		this.nome = nome;
		System.out.println("Criando instância de Pessoa");
	}
}
