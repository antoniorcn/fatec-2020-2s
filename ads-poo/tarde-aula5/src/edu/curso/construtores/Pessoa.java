package edu.curso.construtores;

public class Pessoa extends Animal {
	String nome;
	
	public Pessoa() { 
		this("Jo�o Silva");
	}
	
	public Pessoa(String nome) {
		super();
		this.nome = nome;
		System.out.println("Criando inst�ncia de Pessoa");
	}
}
