package edu.curso.construtores;

public class Aluno extends Pessoa {
	String ra;
	
	public Aluno(String nome, String ra) {
		super(nome);
		this.ra = ra;
		System.out.println("Criando inst�ncia de Aluno");
	}
	
	public Aluno(String nome) { 
		this(nome, "0000");
	}
	
	public Aluno() { 
		this("Jo�o Silva");
	}

}
