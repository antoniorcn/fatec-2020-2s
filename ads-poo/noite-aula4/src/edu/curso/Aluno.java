package edu.curso;

public class Aluno {

	String nome;
	
	public Aluno() { 
		this("SEM NOME");
		System.out.println("qualquer coisa");
	}
	
	public Aluno(String n) { 
		this.nome = n;
		System.out.println("Aluno " + nome + " foi instanciado");
	}
}
